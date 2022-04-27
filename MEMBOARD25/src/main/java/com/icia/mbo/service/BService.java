package com.icia.mbo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbo.dao.BDAO;
import com.icia.mbo.dto.BDTO;
import com.icia.mbo.dto.MDTO;
import com.icia.mbo.dto.PDTO;

@Service
public class BService {

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private BDAO bdao;
	
	
	// 게시글 등록 메소드
	public ModelAndView bWrite(BDTO board) throws IllegalStateException, IOException {
		
		// 파일처리
		
		// (1)중복된 파일 이름 방지를 위한 UUID
		UUID uuid = UUID.randomUUID();
				
		// (2)파일처리를 위한 업로드 파일 설정
		MultipartFile bFile = board.getbFile();
				
		// (3)업로드 한 파일 이름 설정
		String fileName = uuid.toString().substring(0,8) + "_" + bFile.getOriginalFilename();
				
		// (4)파일업로드 경로 설정
		String savePath = "C:/Users/user/git/MEMBOARD25/MEMBOARD25/src/main/webapp/resources/fileUpload/" + fileName;
				
		// (5)업로드 한 파일이 있을 경우 실행
		if(!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
			board.setbFileName(fileName);
		}
		
		
		int result = bdao.bWrite(board);
		
		if(result>0) {
			// 등록성공
			mav.setViewName("index");
		} else {
			// 등록실패
			mav.setViewName("index");
		}
		
		return mav;
	}


	public ModelAndView bList(int page, int limit) {
		int block = 5;
		
		// 전체 회원수
		int mCount = bdao.bCount();
		
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		int maxPage = (int)(Math.ceil((double)mCount/limit));	// 7
		int startPage = (((int)(Math.ceil((double)page/block)))-1) * block + 1;
		int endPage = startPage + block - 1;
		
		if(endPage> maxPage) {
			endPage = maxPage;
		}
		
		// 페이지 객체 생성
		PDTO paging = new PDTO();
		
		paging.setPage(page);
		
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		
		paging.setLimit(limit);
		
		List<MDTO> blist = bdao.bList(paging);
		
		mav.addObject("blist", blist);
		mav.addObject("paging", paging);
		mav.setViewName("B_List");
		
		return mav;
	}


	public ModelAndView bView(int bNum) {
		BDTO board = bdao.bView(bNum);
		
		mav.setViewName("B_View");
		mav.addObject("view", board);
		
		return mav;
	}


	public ModelAndView bModiForm(int bNum) {
		BDTO board = bdao.bView(bNum);
		
		mav.addObject("modi", board);
		mav.setViewName("B_Modify");
		
		return mav;
	}


	public ModelAndView bModify(BDTO board) throws IllegalStateException, IOException {
		// 파일처리
		
				// (1)중복된 파일 이름 방지를 위한 UUID
				UUID uuid = UUID.randomUUID();
						
				// (2)파일처리를 위한 업로드 파일 설정
				MultipartFile bFile = board.getbFile();
						
				// (3)업로드 한 파일 이름 설정
				String fileName = uuid.toString().substring(0,8) + "_" + bFile.getOriginalFilename();
						
				// (4)파일업로드 경로 설정
				String savePath = "C:/Users/user/git/MEMBOARD25/MEMBOARD25/src/main/webapp/resources/fileUpload/" + fileName;
						
				// (5)업로드 한 파일이 있을 경우 실행
				if(!bFile.isEmpty()) {
					bFile.transferTo(new File(savePath));
					board.setbFileName(fileName);
				}
				
				
				int result = bdao.bModify(board);
				
				if(result>0) {
					// 등록성공
					mav.setViewName("redirect:/bList");
				} else {
					// 등록실패
					mav.setViewName("index");
				}
				
				return mav;
	}


	public ModelAndView bDelete(int bNum) {
		int result = bdao.bDelete(bNum);
		
		if(result>0) {
			mav.setViewName("redirect:/bList");
		} else {
			mav.setViewName("redirect:/bView?bNum="+bNum);
		}
		
		return mav;
	}

}

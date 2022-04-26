package com.icia.mbo.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbo.dao.MDAO;
import com.icia.mbo.dto.MDTO;
import com.icia.mbo.dto.PDTO;

@Service
public class MService {

	// 1. ModelAndView 객체 생성
	private ModelAndView mav = new ModelAndView();
	
	// 2. DAO(Repository) 연결
	@Autowired
	private MDAO mdao;
	
	// 3. session 설정
	@Autowired
	private HttpSession session;
	
	
	// 회원가입 메소드
	public ModelAndView mJoin(MDTO member) throws IllegalStateException, IOException {
		System.out.println("[2]controller에서 service로 가져온 member 정보\n " + member);
		// 1. 파일 업로드 처리
		
		// (1)중복된 파일 이름 방지를 위한 UUID
		UUID uuid = UUID.randomUUID();
		
		// (2)파일처리를 위한 업로드 파일 설정
		MultipartFile mProfile = member.getmProfile();
		
		// (3)업로드 한 파일 이름 설정
		String fileName = uuid.toString().substring(0,8) + "_" + mProfile.getOriginalFilename();
		
		// (4)파일업로드 경로 설정
		String savePath = "C:/Users/user/git/MEMBOARD25/MEMBOARD25/src/main/webapp/resources/profile/" + fileName;
		
		// (5)업로드 한 파일이 있을 경우 실행
		if(!mProfile.isEmpty()) {
			mProfile.transferTo(new File(savePath));
			member.setmProfileName(fileName);
		}
		
		// 2. 주소 처리
		String addr1 = member.getAddr1();
		String addr2 = member.getAddr2();
		String addr3 = member.getAddr3();
		
		String mAddr = "("+addr1+")"+addr2+" "+addr3;
		
		
		if(addr1.equals("")) {
			member.setmAddr(mAddr);
		}
		
		
		// 가입 여부를 확인하는 result 변수 선언
		int result = mdao.mJoin(member);
		
		if(result>0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("index");
		}
		
		return mav;
	}

	// 아이디 중복체크 메소드
	public ModelAndView idCheck(String mId) {
		System.out.println("[2]controller에서 service로 가져온 mId 정보\n " + mId);
		
		String checkId = mdao.idCheck(mId);
		
		if(checkId==null) {
			// 아이디 사용가능
			mav.setViewName("M_Join1");
			mav.addObject("checkId", mId);
		} else {
			// 아이디 사용불가
			mav.setViewName("M_Join2");
			mav.addObject("checkId", mId);
		}
		
		return mav;
	}

	// 회원목록 메소드(페이징처리)
	public ModelAndView mList(int page, int limit) {
		
		// 한화면에 보여줄 페이지 번호 갯수
		int block = 5;
		
		// 전체 회원수
		int mCount = mdao.mCount();
		
		
		
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
		
		List<MDTO> mlist = mdao.mList(paging);
		
		mav.addObject("mlist", mlist);
		mav.addObject("paging", paging);
		mav.setViewName("M_List");
		
		return mav;
	}

	public ModelAndView mView(String mId) {
		MDTO member = mdao.mView(mId);
		
		mav.setViewName("M_View");
		mav.addObject("mView", member);
		return mav;
	}

}

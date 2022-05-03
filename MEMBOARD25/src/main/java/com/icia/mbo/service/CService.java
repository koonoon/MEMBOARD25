package com.icia.mbo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbo.dao.CDAO;
import com.icia.mbo.dto.CDTO;

@Service
public class CService {

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private CDAO cdao;
	
	// 댓글 목록을 출력하기 위한 객체 생성
	List<CDTO> commentList = new ArrayList<CDTO>();

	// 댓글 목록 불러오기
	public List<CDTO> cList(int cbNum) {
		
		commentList = cdao.cList(cbNum);
		return commentList;
	}

	// 댓글 입력하기
	public List<CDTO> cWrite(CDTO comm) {
		
		int result = cdao.cWrite(comm);
		
		if(result>0) {
			commentList = cdao.cList(comm.getCbNum());
		} else {
			commentList = null;
		}
		
		return commentList;
	}

	// 댓글 삭제하기
	public List<CDTO> cDelete(CDTO comm) {
		int result = cdao.cDelete(comm);
		
		if(result>0) {
			commentList = cdao.cList(comm.getCbNum());
		} else {
			commentList = null;
		}
		return commentList;
	}

	public List<CDTO> cModify(CDTO comm) {
		int result = cdao.cModify(comm);
		
		if(result>0) {
			commentList = cdao.cList(comm.getCbNum());
		} else {
			commentList = null;
		}
		return commentList;
	}
}

package com.icia.mbo.service;

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

	public List<CDTO> cList(int cbNum) {
		
		List<CDTO> commentList = cdao.cList(cbNum);
		
		return commentList;
	}
}

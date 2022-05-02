package com.icia.mbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbo.dto.CDTO;
import com.icia.mbo.service.CService;

@Controller
@RequestMapping("/comment")
public class CController {

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private CService csvc;
	
	@RequestMapping(value="/cList", method=RequestMethod.POST)
	public @ResponseBody List<CDTO> cList(@RequestParam(value="cbNum", required = true)int cbNum){
		
		List<CDTO> commentList = csvc.cList(cbNum);
		
		return commentList;
	}
}

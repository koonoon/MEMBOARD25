package com.icia.mbo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	List<CDTO> commentList = new ArrayList<CDTO>();
	
	@RequestMapping(value="/cList", method=RequestMethod.POST)
	public @ResponseBody List<CDTO> cList(@RequestParam(value="cbNum", required = true)int cbNum){
		
		commentList = csvc.cList(cbNum);
		
		return commentList;
	}
	
	// cWrite : 댓글 입력 ajax
	@RequestMapping(value="/cWrite", method=RequestMethod.POST)
	public @ResponseBody List<CDTO> cWrite(@ModelAttribute CDTO comm){
		
		commentList = csvc.cWrite(comm);
		
		return commentList;
	}
	
	// cDelete : 댓글 삭제 ajax
	@RequestMapping(value="/cDelete", method=RequestMethod.POST)
	public @ResponseBody List<CDTO> cDelete(@ModelAttribute CDTO comm){
		
		commentList = csvc.cDelete(comm);
		
		return commentList;
	}
	
	// cModify : 댓글 수정 ajax
	@RequestMapping(value="/cModify", method=RequestMethod.POST)
	public @ResponseBody List<CDTO> cModify(@ModelAttribute CDTO comm){
		
		commentList = csvc.cModify(comm);
		
		return commentList;
	}
}

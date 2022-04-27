package com.icia.mbo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbo.dto.BDTO;
import com.icia.mbo.service.BService;

@Controller
public class BController {
	
	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private BService bsvc;
	
	// bWrtieForm : 게시글 작성 페이지로 이동
	@RequestMapping(value="bWriteForm", method=RequestMethod.GET)
	public String bWrtieForm() {
		return "B_Write";
	}
	
	// bWrite : 게시글 작성 메소드
	@RequestMapping(value="bWrite", method=RequestMethod.POST)
	public ModelAndView bWrite(@ModelAttribute BDTO board) throws IllegalStateException, IOException {
		mav = bsvc.bWrite(board);
		return mav;
	}
	
	// bList : 게시글 목록
	@RequestMapping(value = "/bList", method = RequestMethod.GET)
	public ModelAndView bList(@RequestParam(value="page", required=false, defaultValue="1")int page, @RequestParam(value="limit", required=false, defaultValue="5")int limit) {
		
		mav = bsvc.bList(page, limit);
		
		return mav;
	}
	
	// bView : 게시글 상세보기
	@RequestMapping(value = "/bView", method = RequestMethod.GET)
	public ModelAndView bView(@RequestParam("bNum")int bNum) {
		
		mav = bsvc.bView(bNum);
		
		return mav;
	}
	
	// bModiForm : 수정페이지로 이동
	@RequestMapping(value = "/bModiForm", method = RequestMethod.GET)
	public ModelAndView bModiForm(@RequestParam("bNum")int bNum) {
		
		mav = bsvc.bModiForm(bNum);
		
		return mav;
	}
	
	// bModify : 게시글 수정
	@RequestMapping(value="bModify", method=RequestMethod.POST)
	public ModelAndView bModify(@ModelAttribute BDTO board) throws IllegalStateException, IOException {
		mav = bsvc.bModify(board);
		return mav;
	}
	
	// bDelete : 게시글 삭제
	@RequestMapping(value = "/bDelete", method = RequestMethod.GET)
	public ModelAndView bDelete(@RequestParam("bNum")int bNum) {
		
		mav = bsvc.bDelete(bNum);
		
		return mav;
	}
	
}

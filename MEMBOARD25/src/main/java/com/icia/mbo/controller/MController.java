package com.icia.mbo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbo.dto.MDTO;
import com.icia.mbo.service.MService;

@Controller
public class MController {

	// ModelAndView 객체 생성
	private ModelAndView mav = new ModelAndView();
	
	// Service 연결
	@Autowired
	private MService msvc;
	
	// session 설정
	@Autowired
	private HttpSession session;
	
	// 프로젝트 첫 실행 시
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	// mJoinForm : 회원가입 페이지로 이동
	@RequestMapping(value = "/mJoinForm", method = RequestMethod.GET)
	public String mJoinForm() {
		return "M_Join";
	}
	
	// mLoginForm : 로그인 페이지로 이동
	@RequestMapping(value = "/mLoginForm", method = RequestMethod.GET)
	public String mLoginForm() {
		return "M_Login";
	}
	
	// mJoin : 회원가입 메소드
	@RequestMapping(value = "/mJoin", method = RequestMethod.POST)
	public ModelAndView mJoin(@ModelAttribute MDTO member) throws IllegalStateException, IOException {
		System.out.println("[1]jsp에서 Controller 가져온 member 정보\n " + member);
	
		mav = msvc.mJoin(member);
		
		System.out.println("[4]service에서 Controller 가져온 mav 정보\n " + mav);
		
		return mav;
	}
	
	// idCheck : 아이디 중복체크
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public ModelAndView idCheck(@RequestParam(value="mId", required=true)String mId)  {
		System.out.println("[1]jsp에서 Controller 가져온 mId 정보\n " + mId);
	
		mav = msvc.idCheck(mId);
		
		System.out.println("[4]service에서 Controller 가져온 mav 정보\n " + mav);
		
		return mav;
	}
	
	// mList : 회원목록보기 메소드
	@RequestMapping(value = "/mList", method = RequestMethod.GET)
	public ModelAndView mList(@RequestParam(value="page", required=false, defaultValue="1")int page, @RequestParam(value="limit", required=false, defaultValue="5")int limit) {
		System.out.println("[1]jsp에서 Controller 가져온 page : " + page + ", limit : " + limit);
		
		mav = msvc.mList(page, limit);
		
		return mav;
	}
	
	// mView : 회원상세보기 메소드
	@RequestMapping(value = "/mView", method = RequestMethod.GET)
	public ModelAndView mView(@RequestParam("mId")String mId) {
		
		mav = msvc.mView(mId);
		
		return mav;
	}
	
	// mLogin : 로그인 메소드
	@RequestMapping(value = "/mLogin", method = RequestMethod.POST)
	public ModelAndView mLogin(@ModelAttribute MDTO member) {
		mav = msvc.mLogin(member);
		return mav;
	}
	
	
	// mLogout : 로그아웃 메소드
	@RequestMapping(value = "/mLogout", method = RequestMethod.GET)
	public String mLogout() {
		session.invalidate();
		return "index";
	}
	
	// mModiForm : 수정페이지로 회원정보를 가지고 이동
	@RequestMapping(value = "/mModiForm", method = RequestMethod.GET)
	public ModelAndView mModiForm(@RequestParam("mId")String mId) {
		
		mav = msvc.mModiForm(mId);
		
		return mav;
	}
	
	// mModify : 회원수정 메소드
	@RequestMapping(value = "/mModify", method = RequestMethod.POST)
	public ModelAndView mModify(@ModelAttribute MDTO member) throws IllegalStateException, IOException {
		
		mav = msvc.mModify(member);
		
		return mav;
	}
	
	
	
	// mDelete : 회원삭제 메소드
		@RequestMapping(value = "/mDelete", method = RequestMethod.GET)
		public ModelAndView mDelete(@RequestParam("mId")String mId) {
			
			mav = msvc.mDelete(mId);
			
			return mav;
		}
}

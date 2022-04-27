package com.icia.mbo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mbo.dto.MDTO;
import com.icia.mbo.dto.PDTO;

@Repository
public class MDAO {

	// sql(mapper)연결
	@Autowired
	private SqlSessionTemplate sql;
	
	
	// 회원가입 메소드
	public int mJoin(MDTO member) {
		System.out.println("[3]service에서 dao로 가져온 member 정보\n " + member);
		return sql.insert("Member.mJoin",member);
	}


	// 아이디 중복체크 메소드
	public String idCheck(String mId) {
		
		return sql.selectOne("Member.idCheck",mId);
	}

	// 회원수 메소드
	public int mCount() {
		return sql.selectOne("Member.mCount");
	}

	// 회원목록 메소드
	public List<MDTO> mList(PDTO paging) {
		return sql.selectList("Member.mList", paging);
	}


	public MDTO mView(String mId) {
		return sql.selectOne("Member.mView", mId);
	}


	public MDTO mLogin(MDTO member) {
		return sql.selectOne("Member.mLogin", member);
	}


	public int mModify(MDTO member) {
		System.out.println("[3]수정dao : " + member);
		return sql.update("Member.mModify", member);
	}


	public int mDelete(String mId) {
		return sql.delete("Member.mDelete", mId);
	}


}

package com.icia.mbo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mbo.dto.CDTO;

@Repository
public class CDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public List<CDTO> cList(int cbNum) {
		
		return sql.selectList("Comment.cList", cbNum);
	}
}

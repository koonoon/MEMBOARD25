package com.icia.mbo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mbo.dto.BDTO;
import com.icia.mbo.dto.MDTO;
import com.icia.mbo.dto.PDTO;

@Repository
public class BDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int bWrite(BDTO board) {
		
		return sql.insert("Board.bWrite", board);
	}

	public int bCount() {
		
		return sql.selectOne("Board.bCount");
	}

	public List<MDTO> bList(PDTO paging) {
		
		return sql.selectList("Board.bList", paging);
	}

	public BDTO bView(int bNum) {
		sql.update("Board.hit", bNum);
		return sql.selectOne("Board.bView", bNum);
	}

	public int bModify(BDTO board) {
		
		return sql.update("Board.bModify", board);
	}

	public int bDelete(int bNum) {
		
		return sql.delete("Board.bDelete", bNum);
	}

	

}

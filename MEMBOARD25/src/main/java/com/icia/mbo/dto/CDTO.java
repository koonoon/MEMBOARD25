package com.icia.mbo.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

// CommentsDTO
public class CDTO {
	
	// 필드선언
	private int cNum;
	private int cbNum;
	private String cWriter;
	private String cContents;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date cDate;
	
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public int getCbNum() {
		return cbNum;
	}
	public void setCbNum(int cbNum) {
		this.cbNum = cbNum;
	}
	public String getcWriter() {
		return cWriter;
	}
	public void setcWriter(String cWriter) {
		this.cWriter = cWriter;
	}
	public String getcContents() {
		return cContents;
	}
	public void setcContents(String cContents) {
		this.cContents = cContents;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	
	@Override
	public String toString() {
		return "CDTO [cNum=" + cNum + ", cbNum=" + cbNum + ", cWriter=" + cWriter + ", cContents=" + cContents
				+ ", cDate=" + cDate + "]";
	}
	
	
	
}

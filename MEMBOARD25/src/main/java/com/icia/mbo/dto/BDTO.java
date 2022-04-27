package com.icia.mbo.dto;

import java.sql.Date;
import org.springframework.web.multipart.MultipartFile;

public class BDTO {
	private int bNum;
	private String bWriter;
	private String bTitle;
	private String bContent;
	private Date bDate;
	private int bHit;
	
	private MultipartFile bFile;
	private String bFileName;
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public MultipartFile getbFile() {
		return bFile;
	}
	public void setbFile(MultipartFile bFile) {
		this.bFile = bFile;
	}
	public String getbFileName() {
		return bFileName;
	}
	public void setbFileName(String bFileName) {
		this.bFileName = bFileName;
	}
	@Override
	public String toString() {
		return "BDTO [bNum=" + bNum + ", bWriter=" + bWriter + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", bDate=" + bDate + ", bHit=" + bHit + ", bFile=" + bFile + ", bFileName=" + bFileName + "]";
	}
	
	
}
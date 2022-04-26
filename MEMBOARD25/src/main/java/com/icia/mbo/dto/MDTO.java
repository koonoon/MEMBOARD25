package com.icia.mbo.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MDTO {
	private String mId;
	private String mPw;
	private String mName;
	private Date mBirth;
	private String mGender;
	private String mPhone;
	private String mAddr;
	private String mEmail;
	
	private MultipartFile mProfile;
	private String mProfileName;
	
	// 주소 api를 위한 필드 선언
	private String addr1;
	private String addr2;
	private String addr3;
	
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public Date getmBirth() {
		return mBirth;
	}
	public void setmBirth(Date mBirth) {
		this.mBirth = mBirth;
	}
	public String getmGender() {
		return mGender;
	}
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmAddr() {
		return mAddr;
	}
	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public MultipartFile getmProfile() {
		return mProfile;
	}
	public void setmProfile(MultipartFile mProfile) {
		this.mProfile = mProfile;
	}
	public String getmProfileName() {
		return mProfileName;
	}
	public void setmProfileName(String mProfileName) {
		this.mProfileName = mProfileName;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	
	@Override
	public String toString() {
		return "MDTO [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mBirth=" + mBirth + ", mGender=" + mGender
				+ ", mPhone=" + mPhone + ", mAddr=" + mAddr + ", mEmail=" + mEmail + ", mProfile=" + mProfile
				+ ", mProfileName=" + mProfileName + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr3=" + addr3 + "]";
	}
	
	
}

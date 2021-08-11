package com.spring.biz.member.serviceimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.service.ComCodeVO;
import com.spring.biz.member.service.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	// 회원가입
	public void insertMember(MemberVO vo){
		mybatis.insert("member.signup", vo);
	}
	
	//로그인
	public boolean loginCheck(MemberVO vo) {
		String loginCheck = mybatis.selectOne("member.loginCheck", vo);
		return loginCheck != null;
	}
	
	//아이디 중복 체크
	public int idCheck(String user_id) {
		int result = mybatis.selectOne("member.idcheck", user_id);
		return result;
	}
	
	 //휴대폰 번호 앞자리 가져오기
	public List<ComCodeVO> user_phone(ComCodeVO vo){
		List<ComCodeVO> user_phone = mybatis.selectList("comcode.user_phone");
		return user_phone;
	}
	
	
	
	
	
	
	
	/*

	 * //<!-- 회원탈퇴 아이디 유효성 검사 --> public String Withdrawal_id(String id) { return
	 * mybatis.selectOne("member.Withdrawal_id", id); }
	 * 
	 * //아이디, 이메일 확인(비밀번호 찾기) public void updatePWD(MemberVO vo) {
	 * mybatis.update("member.updatepassword", vo); }
	 * 
	 * //아이디, 이메일 확인(비밀번호 찾기) public String checkIdEmail(MemberVO vo) { return
	 * mybatis.selectOne("member.checkIdEmail", vo); }
	 * 
	 * //일반 회원 정보 상세 보기 public MemberVO viewmember(String loginId){ return
	 * mybatis.selectOne("member.viewmember", loginId); }
	 * 
	 * //일반 회원 정보 수정 public void updateMyPage(MemberVO vo) {
	 * mybatis.update("member.updateMyPage", vo); } //비밀번호 변경 public void
	 * updatePwd(MemberVO vo) { mybatis.update("member.updatePassword", vo); }
	 * 
	 * //회원 탈퇴 public void deleteMember(String password) {
	 * mybatis.update("member.deleteMember", password); }
	 */
}











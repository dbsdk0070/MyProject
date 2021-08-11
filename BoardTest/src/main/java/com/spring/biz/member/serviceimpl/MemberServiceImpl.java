package com.spring.biz.member.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.service.ComCodeVO;
import com.spring.biz.member.service.MemberService;
import com.spring.biz.member.service.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	// 회원가입 정보 입력
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}
	
	@Override
	//로그인
	public boolean loginCheck(MemberVO vo) {
		return memberDAO.loginCheck(vo);
	}
	
	@Override
	//아이디 중복체크
	public int idCheck(String user_id) {
		int result = memberDAO.idCheck(user_id);
		return result;
	}
	
	//휴대폰 번호 앞자리 가져오기
	public List<ComCodeVO> user_phone(ComCodeVO vo){
		return memberDAO.user_phone(vo);
	}
	
	/*
	 * // 회원탈퇴 아이디 유효성 검사
	 * 
	 * @Override public String Withdrawal_id(String id) { return
	 * memberDAO.Withdrawal_id(id); }
	 * 
	 * //임시 비밀번호로 변경
	 * 
	 * @Override public void updatePWD(MemberVO vo) { memberDAO.updatePWD(vo); }
	 * 
	 * //비밀번호 찾기 이메일 체크
	 * 
	 * @Override public String checkIdEmail(MemberVO vo) { return
	 * memberDAO.checkIdEmail(vo); }
	 * 
	 * //일반 회원 상세정보 불러오기
	 * 
	 * @Override public MemberVO viewmember(String loginId) { return
	 * memberDAO.viewmember(loginId); }
	 * 
	 * @Override public void updateMyPage(MemberVO vo) { memberDAO.updateMyPage(vo);
	 * }
	 * 
	 * //비밀번호 변경
	 * 
	 * @Override public void updatePwd(MemberVO vo) { memberDAO.updatePwd(vo); }
	 * 
	 * //회원탈퇴
	 * 
	 * @Override public void deleteMember(String password) {
	 * memberDAO.deleteMember(password); }
	 */
}

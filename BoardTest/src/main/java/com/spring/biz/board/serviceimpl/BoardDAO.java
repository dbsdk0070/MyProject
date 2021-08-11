package com.spring.biz.board.serviceimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.service.BoardListVO;
import com.spring.biz.board.service.BoardVO;
import com.spring.biz.board.service.ComCodeVO;
import com.spring.biz.board.service.PagingVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//글쓰기 Type 가져오기
	public List<ComCodeVO> codeNameList(ComCodeVO vo){
		List<ComCodeVO> type = mybatis.selectList("comcode.codeName");
		return type;
	}
	
	//게시판 글 insert
	public void boardinsert(BoardVO vo) {
		mybatis.insert("board.boardinsert", vo);
	}
	
	// 공지사항의 게시물 총 갯수
	public int getBoardCount() {
		return mybatis.selectOne("boardlist.countBoard");
	}
	
	// 페이징 처리 후 공지사항
	public List<BoardListVO> getBoardList(PagingVO vo){
		return mybatis.selectList("boardlist.selectBoard", vo);
	}
	
	//게시글 상세보기
	BoardVO boardDetail(BoardVO vo, int board_num) {
		return mybatis.selectOne("board.boardDetail", vo);
	}
	
	//게시글 수정
	public void boardupdate(BoardVO vo) {
		mybatis.update("board.boardupdate", vo);
	}
	

	

}
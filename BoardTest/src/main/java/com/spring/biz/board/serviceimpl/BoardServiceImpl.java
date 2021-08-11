package com.spring.biz.board.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.service.BoardListVO;
import com.spring.biz.board.service.BoardService;
import com.spring.biz.board.service.BoardVO;
import com.spring.biz.board.service.ComCodeVO;
import com.spring.biz.board.service.PagingVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	//Type가져오기
	public List<ComCodeVO> codeNameList(ComCodeVO vo){
		return boardDAO.codeNameList(vo);
	}
	
	//게시판 insert
	public void boardinsert(BoardVO vo) {
		boardDAO.boardinsert(vo);
	}
	
	@Override
	//게시글 카운트
	public int getBoardCount() {
		return boardDAO.getBoardCount();
	}
	
	@Override
	// 페이징 처리 후 공지사항
	public List<BoardListVO> getBoardList(PagingVO vo){
		return boardDAO.getBoardList(vo);
	}
	
	@Override
	//게시글 상세 조회
	public BoardVO boardDetail(BoardVO vo, int board_num) {
		return boardDAO.boardDetail(vo, board_num);
	}
	
	//게시글 수정
	public void boardupdate(BoardVO vo) {
		boardDAO.boardupdate(vo);
	}

	 
}

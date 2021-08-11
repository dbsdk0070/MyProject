package com.spring.biz.board.service;

import java.util.List;

public interface BoardService {
	
	//게시판 글쓰기 Type
	public List<ComCodeVO> codeNameList(ComCodeVO vo);
	
	//게시판 글 inset
	public void boardinsert(BoardVO vo);
	
	//공지사항의 게시물 총 갯수
	public int getBoardCount();
		
	//페이징 처리 후 공지사항
	public List<BoardListVO> getBoardList(PagingVO vo);
	
	//게시글 상세보기
	BoardVO boardDetail(BoardVO vo, int board_num);
	
	//게시글 수정
	public void boardupdate(BoardVO vo);
	

}

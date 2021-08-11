package com.spring.biz.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.biz.board.service.BoardService;
import com.spring.biz.board.service.BoardVO;
import com.spring.biz.board.service.ComCodeVO;
import com.spring.biz.board.service.PagingVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 게시판 글 등록 페이지로 이동
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertView(ComCodeVO vo, Model model) {

		List<ComCodeVO> list = boardService.codeNameList(vo);
		model.addAttribute("list", list);

		return "/boardInsert.jsp";
	}

	// 게시판 글 insert
	@RequestMapping(value = "/boardinsert.do", method = RequestMethod.POST)
	public String boardListView(BoardVO vo, @RequestParam("board_type") String board_type,
			@RequestParam("board_title") String board_title,
			@RequestParam("board_comment") String board_comment,
			@RequestParam("creator") String creator) {
		System.out.println(board_type);
		System.out.println(board_title);
		System.out.println(board_comment);
		System.out.println(creator);

		boardService.boardinsert(vo);

		return "getBoardList.do";
	}

	// 게시 글 상세보기
	@RequestMapping(value = "/boardlistDetail.do", method = RequestMethod.GET)
	public String boardDetail(BoardVO vo, Model model, @RequestParam("board_num") int num) {
		int board_num = num;

		BoardVO boardvo = boardService.boardDetail(vo, board_num);
		model.addAttribute("boardlistvo", boardvo);

		return "/boardDetail.jsp";
	}
	
	// 게시 글 수정 페이지 이동
		@RequestMapping(value = "/boardlistUpdate.do", method = RequestMethod.GET)
		public String boardUpdate(BoardVO vo, Model model, @RequestParam("board_num") int num) {
			int board_num = num;

			BoardVO boardvo = boardService.boardDetail(vo, board_num);
			model.addAttribute("boardlistvo", boardvo);

			return "/boardUpdate.jsp";
		}
	
	 //게시글 수정
	 @RequestMapping(value = "/updateBoard.do", method = RequestMethod.GET)
	 public String boardUpdate(BoardVO vo, Model model, HttpServletRequest request) {
			 boardService.boardupdate(vo); System.out.println(">>vo: " + vo);
			 model.addAttribute("list", vo);

			 return "boardlistDetail.do";
	 }

	// 게시판 전체 리스트 (페이징 처리 후)
	@RequestMapping("/getBoardList.do")
	public String getBoardListNotice(PagingVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {

		int total = boardService.getBoardCount();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		System.out.println(">>게시판 컨트롤러 vo :" + vo);
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", boardService.getBoardList(vo));

		return "/boardList.jsp";
	}

}

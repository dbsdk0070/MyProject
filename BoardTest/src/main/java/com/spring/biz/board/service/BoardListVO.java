package com.spring.biz.board.service;

public class BoardListVO {
	private String board_title,
	               board_comment,
	               code_name;
	
	private int board_num;
	
	public BoardListVO() {
		
	}
	
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_comment() {
		return board_comment;
	}
	public void setBoard_comment(String board_comment) {
		this.board_comment = board_comment;
	}
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	@Override
	public String toString() {
		return "BoardListVO [board_title=" + board_title + ", board_comment=" + board_comment + ", code_name="
				+ code_name + ", board_num=" + board_num + "]";
	}

}

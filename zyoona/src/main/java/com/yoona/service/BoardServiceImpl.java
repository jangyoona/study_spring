package com.yoona.service;

import com.yoona.dto.BoardAttachDto;
import com.yoona.dto.BoardDto;
import com.yoona.mapper.BoardMapper;

import lombok.Setter;

public class BoardServiceImpl implements BoardService {

	@Setter
	private BoardMapper boardMapper;
	
	
	@Override
	public void setBoard(BoardDto board) {
		
		boardMapper.insertBoard(board);
		
		for(BoardAttachDto attach : board.getAttachments()) {
			attach.setBoardNo(board.getBoardNo());
			boardMapper.insertBoardAttach(attach);
		}
	}
}

package com.yoona.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yoona.dto.BoardAttachDto;
import com.yoona.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	void insertBoard(BoardDto board);

	void insertBoardAttach(BoardAttachDto board);

}

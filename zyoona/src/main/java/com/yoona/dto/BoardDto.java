package com.yoona.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardDto {
	
	private Integer boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private Date modifyDate;
	private int readCount;
	private boolean deleted;
	
	private List<BoardAttachDto> attachments;

}

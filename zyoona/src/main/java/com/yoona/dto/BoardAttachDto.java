package com.yoona.dto;

import lombok.Data;

@Data
public class BoardAttachDto {
	
	private int attachNo;
	private int boardNo;
	private String userFileName;
	private String savedFileName;
	private int downloadCount;

}

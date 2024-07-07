package com.yoona.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDto {

	private String memberId;
	private String passwd;
	private String email;
	private String userType;
	private Date RegDate;
	private boolean active;
	
}

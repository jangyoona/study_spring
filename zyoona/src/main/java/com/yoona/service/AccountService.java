package com.yoona.service;

import com.yoona.dto.MemberDto;

public interface AccountService {

	MemberDto getLoginMember(MemberDto member);

	void registerMember(MemberDto member);

	boolean registerMemberIdCheck(String memberId);
}
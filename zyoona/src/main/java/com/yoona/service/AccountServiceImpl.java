package com.yoona.service;

import com.yoona.common.Util;
import com.yoona.dto.MemberDto;
import com.yoona.mapper.AccountMapper;

import lombok.Setter;

public class AccountServiceImpl implements AccountService {

	@Setter
	private AccountMapper accountMapper;
	
	@Override
	public MemberDto getLoginMember(MemberDto member) {
		
		String hashedPasswd = Util.getHashedString(member.getPasswd(), "SHA-256");
		member.setPasswd(hashedPasswd);
		
		MemberDto loginMember = accountMapper.selectLoginMember(member);
		return loginMember;
	}

	@Override
	public void registerMember(MemberDto member) {
		
		String hashedPasswd = Util.getHashedString(member.getPasswd(), "SHA-256");
		member.setPasswd(hashedPasswd);
		
		accountMapper.insertMember(member);
		
	}

	@Override
	public boolean registerMemberIdCheck(String memberId) {
		int count = accountMapper.selectRegisterMemberId(memberId);
		
		return count == 0;
	}
}

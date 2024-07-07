package com.yoona.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yoona.dto.MemberDto;

@Mapper
public interface AccountMapper {

	MemberDto selectLoginMember(MemberDto member);

	void insertMember(MemberDto member);

	int selectRegisterMemberId(String memberId);
}

package com.org.service;


import org.springframework.stereotype.Service;

import com.org.domain.MemberVO;
import com.org.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
@AllArgsConstructor
public class MoneServiceImpl implements MoneService{
	MemberMapper memberMapper;
	public MemberVO isLogin(MemberVO memberVO) {
		return memberMapper.isLogin(memberVO);
	}
}

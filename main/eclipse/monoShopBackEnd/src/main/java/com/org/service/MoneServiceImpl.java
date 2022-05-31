package com.org.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.org.domain.MemberVO;
import com.org.domain.ShopCartVO;
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
	
	public boolean isEmpty(String mid, Integer pno) {
		return memberMapper.isEmpty(mid, pno);
	}
	
	public List<ShopCartVO> shopcartList(String mid) {
		return memberMapper.shopcartList(mid);
	}
}

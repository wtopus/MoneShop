package com.org.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public ShopCartVO isEmpty(String mid, Integer pno) {
		Map data = new HashMap();
		data.put("mid", mid);
		data.put("pno", pno);
		return memberMapper.isEmpty(data);
	}
	
	public Integer insert(String mid, Integer pno) {
		Map data = new HashMap();
		data.put("mid", mid);
		data.put("pno", pno);
		return memberMapper.insert(data);
	}
	
	public List<ShopCartVO> shopcartList(String mid) {
		return memberMapper.shopcartList(mid);
	}
}

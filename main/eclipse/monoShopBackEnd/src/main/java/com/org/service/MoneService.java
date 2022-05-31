package com.org.service;

import java.util.List;

import com.org.domain.MemberVO;
import com.org.domain.ShopCartVO;

public interface MoneService {
	public MemberVO isLogin(MemberVO memberVO);
	
	public ShopCartVO isEmpty(String mid, Integer pno);
	
	public List<ShopCartVO> shopcartList(String mid);
	
	public Integer insert(String mid, Integer pno);
	
	public Integer delete(String mid, Integer pno);
}

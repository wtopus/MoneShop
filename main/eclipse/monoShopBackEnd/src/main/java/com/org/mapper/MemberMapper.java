package com.org.mapper;

import java.util.List;
import java.util.Map;

import com.org.domain.MemberVO;
import com.org.domain.ShopCartVO;


public interface MemberMapper {
	/* @Select("select * from member ") */
	public List<MemberVO> getList();
	public MemberVO isLogin(MemberVO memberVO);
	
	public ShopCartVO isEmpty(Map data);
	
	public List<ShopCartVO> shopcartList(String mid);
	
	public Integer insert(Map data);
	
	public Integer delete(Map data);
}

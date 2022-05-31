package com.org.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.org.domain.MemberVO;
import com.org.domain.ShopCartVO;


public interface MemberMapper {
	/* @Select("select * from member ") */
	public List<MemberVO> getList();
	public MemberVO isLogin(MemberVO memberVO);
	
	public boolean isEmpty(String mid, Integer pno);
	
	public List<ShopCartVO> shopcartList(String mid);
}

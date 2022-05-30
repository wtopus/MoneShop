package com.org.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.org.domain.MemberVO;


public interface MemberMapper {
	/* @Select("select * from member ") */
	public List<MemberVO> getList();
	public MemberVO isLogin(MemberVO memberVO);
}

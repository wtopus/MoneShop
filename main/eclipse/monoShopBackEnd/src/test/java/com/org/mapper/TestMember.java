package com.org.mapper;

import com.org.config.RootConfig;
import com.org.domain.MemberVO;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class TestMember {
	//@Setter(onMethod = @__({ @Autowired }))
	@Setter(onMethod_= {@Autowired})
	private MemberMapper memberMapper;
	 
	@Test
	public void testGetList() {
		log.info("-----");
		memberMapper.getList().forEach(member-> log.info(member)); //-> 람다식
	}
}

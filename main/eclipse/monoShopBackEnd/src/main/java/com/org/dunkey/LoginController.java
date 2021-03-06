package com.org.dunkey;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.domain.MemberVO;
import com.org.domain.ShopCartVO;
import com.org.service.MoneService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/mone")
@RestController
@Log4j
@AllArgsConstructor
public class LoginController {
	private MoneService service;
	
	@CrossOrigin(origins = "*" )
	@GetMapping(value="/member")
	public ResponseEntity<List> create(MemberVO memberVO){
		List list = new ArrayList<>();
		MemberVO memberVO_ = service.isLogin(memberVO);
		log.info(memberVO);
		log.info(service.shopcartList(memberVO.getMid()));
		list.add(memberVO);
		list.add(service.shopcartList(memberVO.getMid()));
		return memberVO_ == null ? new ResponseEntity<>(null, HttpStatus.ACCEPTED) : new ResponseEntity<>(list, HttpStatus.OK);
	}
	
}

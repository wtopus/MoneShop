package com.org.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Paylog {
	private String mid;
	private Date paydate;
	private Integer price;
}

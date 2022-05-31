package com.org.dunkey;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.org.service.MoneService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@RequestMapping("/mone")
@RestController
@Log4j
@AllArgsConstructor
public class PaymentController {
	private MoneService service;
	
	@CrossOrigin(origins = "*" )
	@PostMapping(value="/paylog", consumes = MediaType.APPLICATION_JSON_VALUE)
	// mid pno받고 -> insert
	public ResponseEntity<String> paylogInsert(@RequestBody Map<String,String> param){
		log.info( "testes" + param.get("mid") + param.get("price"));
		int result = service.paylogInsert(param.get("mid"), Integer.parseInt(param.get("price")));
		log.info("cartAdd : " +result);
		JsonObject obj = new JsonObject();
		obj.addProperty("result", "success");
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*" )
	@DeleteMapping(value="/paylog", consumes = MediaType.APPLICATION_JSON_VALUE)
	// mid pno받고 -> insert
	public ResponseEntity<String> payLogDelete(@RequestBody Map<String, String> param){
		log.info( "testes" + param.get("mid"));
		int result = service.paylogDelete(param.get("mid"));
		log.info("cartAdd : " +result);
		JsonObject obj = new JsonObject();
		obj.addProperty("result", "success");
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
}

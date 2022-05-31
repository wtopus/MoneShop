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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;
import com.org.domain.MemberVO;
import com.org.domain.ShopCartVO;
import com.org.service.MoneService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/mone")
@RestController
@Log4j
@AllArgsConstructor
public class ShopCartController {
	private MoneService service;
	
	@CrossOrigin(origins = "*" )
	@PostMapping(value="/cart", consumes = MediaType.APPLICATION_JSON_VALUE)
	// mid pno받고 -> insert
	public ResponseEntity<String> insert(@RequestBody Map<String,String> param){
		//log.info( "testes" + mid + pno);
		
		log.info( "testes" + param.get("mid") + param.get("pno"));
		//int result = service.insert(param.get("mid"), Integer.parseInt(param.get("pno")));
		//log.info("cartAdd : " +result);
		JsonObject obj = new JsonObject();
		obj.addProperty("result", "success");
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*" )
	@DeleteMapping(value="/cart", consumes = MediaType.APPLICATION_JSON_VALUE)
	// mid pno받고 -> insert
	public ResponseEntity<String> delete(@RequestBody Map<String,String> param){
		log.info( "testes" + param.get("mid") + param.get("pno"));
		int result = service.delete(param.get("mid"), Integer.parseInt(param.get("pno")));
		log.info("cartdelete : " +result);
		JsonObject obj = new JsonObject();
		if(result == 1 ) {
			obj.addProperty("result", "success");
		}else {
			obj.addProperty("result", "fail");
		}
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
	
	
//	@CrossOrigin(origins = "*" )
//	@PostMapping(value="/cart", consumes = MediaType.APPLICATION_JSON_VALUE)
//	// mid pno받고 -> insert
//	public ResponseEntity<String> create(@RequestBody Map<String,String> param){
//		log.info( "testes" + param.get("mid") + param.get("pno"));
//		Boolean result = (service.isEmpty(param.get("mid"), Integer.parseInt(param.get("pno"))) == null) ? true : false;
//		log.info("cartAdd" + result);
//		return new ResponseEntity<>("test", HttpStatus.OK);
//	}
	
}

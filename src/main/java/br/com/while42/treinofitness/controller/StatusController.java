package br.com.while42.treinofitness.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

	private static final String timestampStart = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());
	
	@RequestMapping("/status")
	public String status() {
		return "iniciado: " + timestampStart;
	}
}
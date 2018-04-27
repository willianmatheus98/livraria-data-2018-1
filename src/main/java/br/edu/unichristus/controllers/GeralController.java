package br.edu.unichristus.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeralController {
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
}

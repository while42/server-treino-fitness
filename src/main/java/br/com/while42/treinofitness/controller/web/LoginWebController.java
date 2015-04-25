package br.com.while42.treinofitness.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginWebController {

	@RequestMapping(method = RequestMethod.GET)
    public String template() {
        return "login";
    }

}
package fr.mns.java.mvcsecurity;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@GetMapping
	public String getHello(Model model,Authentication 	authentication) {
		model.addAttribute("username",authentication.getName());
		return "hello";
	}
	
}

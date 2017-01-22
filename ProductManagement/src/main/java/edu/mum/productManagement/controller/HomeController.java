/**
 * 
 */
package edu.mum.productManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yared
 *
 */


@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing webstore");
		return "welcome";
		//return "forward:/welcome/greeting";
	}
	
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
}

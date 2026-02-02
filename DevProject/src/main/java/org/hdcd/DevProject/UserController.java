package org.hdcd.DevProject;

import org.hdcd.DevProject.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/users")
public class UserController {

	@GetMapping("/form")
	public String userForm(Model model) {
	    System.out.println("===== HIT: /users/form =====");
	    model.addAttribute("user", new User());
	    return "userForm";
	}
	
	@PostMapping("/submit")
	public String submitForm(User user, Model model) {
		model.addAttribute("user", user);
		return "userSuccess";
	}
	
	@GetMapping("/ping")
	@ResponseBody
	public String ping() {
	    return "ok";
	}
	
}



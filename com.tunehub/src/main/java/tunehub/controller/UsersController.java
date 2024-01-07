package tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tunehub.entities.Users;
import tunehub.services.UsersService;
@Controller
public class UsersController {
	
@Autowired
UsersService service;


@PostMapping("/register")
public String addUsers(@ModelAttribute Users user) {
	boolean userStatus= service.emailExists(user.getEmail());
	if(userStatus==false) 
	{
		
	service.addUser(user);
	System.out.println("user Added");
	}
	return "home";
}
@PostMapping("/validate")
public String validate(@RequestParam("email")String email,@RequestParam("password")String password)
{
	if(service.validateUser(email,password)==true) {
		String role=service.getRole(email);
		if(role.equals("admin")) {
			return "adminHome";
		}
		else {
			return "customerHome";
		}
	}
	else {
		return "login";
	}
}

}

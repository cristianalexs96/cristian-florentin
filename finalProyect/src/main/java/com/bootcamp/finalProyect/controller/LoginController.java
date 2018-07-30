package com.bootcamp.finalProyect.controller;

import com.bootcamp.finalProyect.model.User;
import com.bootcamp.finalProyect.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@Api(value = "Login microservice", description = "This API has a login functionality")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	HttpSession session;

	@PostMapping(value = "", params = { "user", "pass" })
	@ApiOperation(value = "Login to the system", notes = "Login a signed user to the system" )
	public void login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "user") String username,
			@RequestParam(value = "pass") String password) throws Exception {
		session = request.getSession();
		User user = userService.findByUsername(username);
		if(Objects.nonNull(user))
			if(user.getPassword().equals(password)) {
				session.setAttribute("userid", user.getId());
			}
			else{
				throw  new  Exception("your password is incorrect");
			}
		else{
			throw  new Exception("you must sign in first");
		}

	}
}

package com.negi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negi.config.JwtProvider;
import com.negi.model.User;
import com.negi.repository.UserRepository;
import com.negi.request.LoginRequest;
import com.negi.response.AuthResponse;
import com.negi.service.CustomUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtProvider jwtProvider;
	 
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/signup")
	public AuthResponse createUser(@RequestBody User user) throws Exception{
		
		 String email=user.getEmail();
		 String password=user.getPassword();
		 String fullName=user.getFullName();
		 
		 User isExistEmail=userRepository.findByEmail(email);
		 if(isExistEmail!=null) {
			 throw new Exception("Email is already used with another account");
		 }
		 
		 User createdUser=new User();
		 createdUser.setEmail(email);
		 createdUser.setPassword(passwordEncoder.encode(password));
		 createdUser.setFullName(fullName);
		 
		 User savedUser=userRepository.save(createdUser);
		 
		 Authentication authentication=new UsernamePasswordAuthenticationToken(email, password);
		 
		 SecurityContextHolder.getContext().setAuthentication(authentication);
		 
		 String token=jwtProvider.generateToken(authentication);
		 
		 AuthResponse res=new AuthResponse();
		 res.setJwt(token);
		 res.setMessage("signup success");
		 
		return res;
	}
	
	
	@PostMapping("/signin")
	public AuthResponse signinHandler(@RequestBody LoginRequest loginRequest) {
		
		String username=loginRequest.getEmail();
		String password=loginRequest.getPassword();
		
		Authentication authentication=authenticate(username,password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token=jwtProvider.generateToken(authentication);
		
		AuthResponse res=new AuthResponse();
		res.setJwt(token);
		res.setMessage("signin success");
		 
		return res;	
	}

	private Authentication authenticate(String username, String password) {
		
		UserDetails userDetails=customUserDetailsService.loadUserByUsername(username);
		if (userDetails==null) {
			
			throw new BadCredentialsException("user not found");			
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid password");
		}
		
		 
		return new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
	}

}

package com.example.demo.controller;



import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {	  
    
	  
	  
	  
	  return ResponseEntity.ok(service.save(user));
  }
}
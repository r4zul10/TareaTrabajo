package com.example.demo.controller;



import java.util.Date;
import java.util.UUID;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserCreateResponseDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }
  
  @PostMapping
  public ResponseEntity<UserCreateResponseDTO> createUser(@RequestBody User user) {	  
	  
	  User userCreated = service.save(user);
	  
	  UserCreateResponseDTO userDTO = new UserCreateResponseDTO();
	  UUID uuid = UUID.randomUUID();
	  userDTO.setId(uuid.toString());
	  userDTO.setCreated(new Date().toString());
	  userDTO.setModified("No se puede modificar un usuario al menos si no se le está enviando el ID");
	  userDTO.setLastLogin(new Date().toString());
	  userDTO.setToken( uuid.toString());
	  userDTO.setIsActive(true);
	  
	  return ResponseEntity.ok(userDTO);
  }




}
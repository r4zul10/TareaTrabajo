package com.example.demo.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserCreateResponseDTO;
import com.example.demo.entity.User;
import com.example.demo.error.EmailDuplicadoException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	   public UserCreateResponseDTO createUser(User user) {
	        // Validar email duplicado, si aplica
	        if (userRepository.existsByEmail(user.getEmail())) {
	            throw new EmailDuplicadoException("El correo ya registrado");
	        }

	        User userCreated = userRepository.save(user);

	        UUID uuid = UUID.randomUUID();

	        UserCreateResponseDTO userDTO = new UserCreateResponseDTO();
	        userDTO.setId(userCreated.getId());
	        userDTO.setCreated(new Date().toString());
	        userDTO.setModified("No se puede modificar un usuario al menos si no se le está enviando el ID");
	        userDTO.setLastLogin(new Date().toString());
	        userDTO.setToken(uuid.toString());
	        userDTO.setIsActive(true);

	        return userDTO;
	    }
}
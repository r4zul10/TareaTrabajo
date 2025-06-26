package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.error.EmailDuplicadoException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User save(User user) {

		if (userRepository.existsByEmail(user.getEmail())) {
			throw new EmailDuplicadoException("El correo ya registrado");
		}

		return userRepository.save(user);
	}

}
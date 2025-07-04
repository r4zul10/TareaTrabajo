package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.UserController;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@WebMvcTest(UserController.class)
	public class UserControllerTest {

		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private UserService userService; // Aunque no se use en el método, debe declararse si está como dependencia

		@Autowired
		private ObjectMapper objectMapper;

		@Test
		public void testCreateUserReturnsEmptyUserDTO() throws Exception {
			// Crear un objeto de entrada simulado
			User user = new User();
			user.setName("Juan");
			user.setEmail("juan@test.com");
			user.setPassword("1234");

			// Ejecutar la petición POST
			mockMvc.perform(post("/ruta/del/post") // ← reemplaza con tu ruta real
					.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)))
					.andExpect(status().isOk()).andExpect(jsonPath("$.id").doesNotExist()) // Como el objeto está vacío
					.andExpect(jsonPath("$.token").doesNotExist());
		}
	}
}
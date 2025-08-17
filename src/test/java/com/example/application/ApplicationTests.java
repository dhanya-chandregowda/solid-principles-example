package com.example.application;;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/api/v1/activities"))
			.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":250,\"name\":\"Ion Popescu\",\"address\":\"Str. Veseliei, Nr. 4\",\"zip\":\"253445\",\"city\":null,\"country\":\"Romania\"}]"));
	}

	void context() throws Exception{
		mockMvc.perform(get("/api/v1/activities")).andExpect(status().isNotFound());
	}
}

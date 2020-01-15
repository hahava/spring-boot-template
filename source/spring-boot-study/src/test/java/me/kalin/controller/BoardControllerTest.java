package me.kalin.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
@Slf4j
public class BoardControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testHello() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(mvcResult -> mvcResult.getResponse().getContentAsString().equals("hello Boot!"))
			.andReturn();
	}

}

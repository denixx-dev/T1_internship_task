package org.kazino.t1_task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class T1TaskApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@Test
	void processInput_ReturnsValidResponseEntity_WithInputString_aaaaabcccc() throws Exception{
		//given
		var requestBuilder = get("/?str=aaaaabcccc");
		String expectedString = "\"a\":5, \"c\":4, \"b\":1";
		String request = this.mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

		//when
		this.mockMvc.perform(requestBuilder)
				//then
				.andExpectAll(
						status().isOk(),
						content().string(expectedString)
				);
	}

	@Test
	void processInput_ReturnsValidResponseEntity_WithInputString_ttttyyyyyu() throws Exception{
		//given
		var requestBuilder = get("/?str=ttttyyyyyu");
		String expectedString = "\"y\":5, \"t\":4, \"u\":1";
		String request = this.mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

		//when
		this.mockMvc.perform(requestBuilder)
				//then
				.andExpectAll(
						status().isOk(),
						content().string(expectedString)
				);
	}

	@Test
	void processInput_ReturnsValidResponseEntity_WithInputString_helloworld() throws Exception{
		//given
		var requestBuilder = get("/?str=helloworld");
		String expectedString = "\"l\":3, \"o\":2, \"r\":1, \"d\":1, \"e\":1, \"w\":1, \"h\":1";
		String request = this.mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

		//when
		this.mockMvc.perform(requestBuilder)
				//then
				.andExpectAll(
						status().isOk(),
						content().string(expectedString)
				);
	}

	@Test
	void processInput_ReturnsValidResponseEntity_WithInputString_test() throws Exception{
		//given
		var requestBuilder = get("/?str=test");
		String expectedString = "\"t\":2, \"s\":1, \"e\":1";
		String request = this.mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

		//when
		this.mockMvc.perform(requestBuilder)
				//then
				.andExpectAll(
						status().isOk(),
						content().string(expectedString)
				);
	}

	@Test
	void processInput_ReturnsValidResponseEntity_WithInputString_привет() throws Exception{
		//given
		var requestBuilder = get("/?str=привет");
		String expectedString = "\"р\":1, \"т\":1, \"в\":1, \"е\":1, \"и\":1, \"п\":1";
		String request = this.mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

		//when
		this.mockMvc.perform(requestBuilder)
				//then
				.andExpectAll(
						status().isOk(),
						content().string(expectedString)
				);
	}

}

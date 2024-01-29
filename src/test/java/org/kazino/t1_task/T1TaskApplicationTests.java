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
		String expectedJSON = "{\"a\":5,\"c\":4,\"b\":1}";
		String request = this.mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

		//when
		this.mockMvc.perform(requestBuilder)
				//then
				.andExpectAll(
						status().isOk(),
						content().contentType(MediaType.APPLICATION_JSON)
				);
		assert(expectedJSON.equals(request));
	}

	@Test
	void processInput_ReturnsValidResponseEntity_WithInputString_ttttyyyyyu() throws Exception{
		//given
		var requestBuilder = get("/?str=ttttyyyyyu");
		String expectedJSON = "{\"y\":5,\"t\":4,\"u\":1}";
		String request = this.mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

		//when
		this.mockMvc.perform(requestBuilder)
				//then
				.andExpectAll(
						status().isOk(),
						content().contentType(MediaType.APPLICATION_JSON)
				);
		assert(expectedJSON.equals(request));
	}

}

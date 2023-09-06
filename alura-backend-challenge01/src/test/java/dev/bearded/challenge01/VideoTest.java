package dev.bearded.challenge01;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureTestDatabase
public class VideoTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldGetAllVideos() throws URISyntaxException, Exception {

		mockMvc.perform(get(new URI("/video/videos")).accept(MediaType.APPLICATION_JSON)).andExpectAll(status().isOk());

	}

}

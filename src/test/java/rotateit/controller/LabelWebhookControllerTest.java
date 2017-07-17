package rotateit.controller;

import com.google.common.io.Resources;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.URL;

import static com.google.common.base.Charsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
public class LabelWebhookControllerTest {
    private MockMvc mockMvc;

    private LabelWebhookController labelWebhookController = new LabelWebhookController();

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(labelWebhookController).build();
    }

    @Test
    public void shouldAcceptAndConvertJsonPayloadToLabelPayloadObject() throws Exception {
        String jsonPayload = getContent("/github/label/exampleLabelWebhookRequest.json");

        mockMvc.perform(post("/api/github/labelWebhookRequest")
            .contentType(APPLICATION_JSON)
            .content(jsonPayload))
            .andExpect(status().isOk());
    }

    private String getContent(String resourcePath) throws IOException {
        URL filePath = new ClassPathResource(resourcePath).getURL();
        return Resources.toString(filePath, UTF_8);
    }
}

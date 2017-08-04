package rotateit.controller;

import static com.google.common.base.Charsets.UTF_8;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.isA;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.google.common.io.Resources;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import rotateit.domain.github.label.LabelReceivedEvent;
import rotateit.service.EventPublisher;

@RunWith(SpringJUnit4ClassRunner.class)
public class LabelWebhookControllerTest {
    private static final String JSON_REQUEST_PATH = "/github/label/exampleLabelWebhookRequest.json";
    private static final String JSON_REQUEST = getContent(JSON_REQUEST_PATH);
    private static final String ENDPOINT = "/api/github/labelWebhookRequest";
    private MockMvc mockMvc;

    @Mock
    private EventPublisher publisher;

    @InjectMocks
    private LabelWebhookController labelWebhookController;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(labelWebhookController).build();
    }

    @Test
    public void shouldAcceptAndConvertJsonPayloadToLabelPayloadObject() throws Exception {
        performPostOf(JSON_REQUEST).andExpect(status().isOk());
    }

    @Test
    public void shouldPublishLabelPayload() throws Exception {
        performPostOf(JSON_REQUEST);

        then(publisher).should().publish(isA(LabelReceivedEvent.class));
    }

    private ResultActions performPostOf(String jsonPayload) throws Exception {
        return mockMvc.perform(post(ENDPOINT)
            .contentType(APPLICATION_JSON)
            .content(jsonPayload));
    }

    private static String getContent(String resourcePath) {
        URL filePath;
        String resource = null;
        try {
            filePath = new ClassPathResource(resourcePath).getURL();
            resource = Resources.toString(filePath, UTF_8);
        } catch (Exception e) {
            fail("Reading and loading file: " + resourcePath + " failed. Details : " + e.getMessage());
        }
        return resource;
    }
}

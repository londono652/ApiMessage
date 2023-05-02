package com.demospring.messageapi.controllers;

import com.demospring.messageapi.models.entity.Message;
import com.demospring.messageapi.services.MessageService;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MessageControllerTest {


    private MockMvc mvc;

    @MockBean
    private MessageService messageService;
    Message testMessage;

    @BeforeEach
    void setUp(WebApplicationContext wac) {
        // instance mvc
        this.mvc = MockMvcBuilders.standaloneSetup(new MessageControllerTest()).build();
        this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();

        testMessage = new Message();
        testMessage.setId(1L);
        testMessage.setMsg("This is a test");
        testMessage.setTo("Juan");
        testMessage.setFrom("Rita");
        testMessage.setTimeToLifeSec(45);
    }

    @Test
    @DisplayName("It should return message")
    @Disabled
    public void givenProduct_whenCreateProduct_thenReturnProduct()
            throws Exception {
        // Given
        MvcResult result = this.mvc.perform(post("/test/simple/post")
                        .content(testMessage.toString())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        //then
        Assertions.assertEquals("{\"id\":1}", result.getResponse().getContentAsString());
    }


}
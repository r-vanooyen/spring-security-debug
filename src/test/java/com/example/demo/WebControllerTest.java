package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void whenCalledGetWithoutAuth_shouldReturn401() throws Exception {

        mockMvc.perform(get("/get"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void whenCalledGetWithAuth_shouldReturn200() throws Exception {

        mockMvc.perform(get("/get"))
                .andExpect(status().isOk());
    }

    @Test
    void whenCalledPostWithoutAuth_shouldReturn401() throws Exception {

        mockMvc.perform(post("/post")
                        .with(csrf()))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void whenCalledPostWithAuth_shouldReturn200() throws Exception {

        mockMvc.perform(post("/post")
                        .with(csrf()))
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser
    void whenCalledPostWithAuthButNoCSRF_shouldReturn403() throws Exception {
        mockMvc.perform(post("/post"))
                .andExpect(status().isForbidden());
    }

}
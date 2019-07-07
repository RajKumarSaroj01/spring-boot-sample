package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpControllerTests {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void getGender()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/emp/genders").contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*]").isNotEmpty())
                .andDo(print());
    }

    @Test
    public void getDepartment()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/emp/departments").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*]").isNotEmpty())
                .andDo(print());
    }

    @Test
    public void getEmployee()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/emp/emps").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void createEmployee()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/emp").contentType(MediaType.APPLICATION_JSON)
                .content("{\"gender\":{\"id\":1,\"name\":\"MALE\"},\"dob\":\"1977-02-02\",\"department\":{\"id\":1,\"name\":\"Finance\"},\"fname\":\"Mr Bean\",\"lname\":\"Bean\"}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
}

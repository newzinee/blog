package com.treasurebear.menu.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/02/26
 */
@SpringBootTest
@AutoConfigureMockMvc
class MenuControllerTest {

    @Autowired
    MenuController menuController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getV1MenusSuccess() throws Exception {
        mockMvc.perform(get("/v1/menus"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getV2MenusSuccess() throws Exception {
        mockMvc.perform(get("/v2/menus"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
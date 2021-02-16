package com.fsancho.pokerest.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsancho.poke_rest.controller.PokemonController;



public class PokemonControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PokemonController()).build();
    }

//    @Test
//    public void testHomePage() throws Exception {
//        this.mockMvc.perform(get("/")).andExpect(status().isOk())
//                .andExpect(content().string("This is Home page"));
//    }
//
//    @Test
//    public void testHelloPage() throws Exception {
//        this.mockMvc.perform(get("/hello")).andExpect(status().isOk())
//                .andExpect(content().string("Hello there!"));
//    }
}

package com.fsancho.poke_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsancho.poke_rest.model.PokemonDTO;
import com.fsancho.poke_rest.service.PokemonService;
@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

    @Autowired
    private PokemonService pokemonService;

    @GetMapping(value = "/pokemones/{offset}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getAll(@PathVariable String offset,
            @RequestParam(value = "limit", required = true) String limit) {
        try {
            int intOffSet = Integer.valueOf(offset);
            int intLimit = Integer.valueOf(limit);

            List<PokemonDTO> productos = pokemonService.searchPokemonLazy(intOffSet, intLimit);
            
            logger.info("There are products to list");
            return new ResponseEntity<>(productos, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Produced exception:" + e.getMessage());
            return new ResponseEntity<List<PokemonDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/pokemones")
    @ResponseBody
    public List<PokemonDTO> getAll() {
        try {
            int intOffSet = Integer.valueOf(0);
            int intLimit = Integer.valueOf(0);

            List<PokemonDTO> productos = pokemonService.searchPokemonLazy(intOffSet, intLimit);
            return productos;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}

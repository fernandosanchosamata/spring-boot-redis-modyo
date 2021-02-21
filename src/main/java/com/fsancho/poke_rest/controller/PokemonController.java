package com.fsancho.poke_rest.controller;

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

import com.fsancho.poke_rest.dto.EvolutionDTO;
import com.fsancho.poke_rest.dto.PokemonDTO;
import com.fsancho.poke_rest.model.Pokemon;
import com.fsancho.poke_rest.service.PokemonService;

/**
 * @author Fernando Sancho
 *
 */
@RestController
@RequestMapping("/api")
public class PokemonController {

	private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

	@Autowired
	private PokemonService pokemonService;

	@GetMapping(value = "/pokemones", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getPokemones(@RequestParam(value = "offset", required = true) String offset,
			@RequestParam(value = "limit", required = true) String limit) {
		List<PokemonDTO> productos = pokemonService.searchPokemonLazy(offset, limit);
		logger.info("Devolviendo pokemones");
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}

	@GetMapping(value = "/evoluciones/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getEvoluciones(@PathVariable("id") String id) {
		List<EvolutionDTO> productos = pokemonService.findEvolutions(id);
		logger.info("Devolviendo pokemones");
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}

	@GetMapping("/information/{id}")
	@ResponseBody
	Pokemon information(@PathVariable("id") String id) {
		return pokemonService.findPokemonById(id);
	}
}

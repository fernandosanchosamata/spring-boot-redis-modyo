package com.fsancho.pokerest.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fsancho.poke_rest.PokeRestApplication;
import com.fsancho.poke_rest.dto.EvolutionDTO;
import com.fsancho.poke_rest.dto.PokemonDTO;
import com.fsancho.poke_rest.model.Pokemon;
import com.fsancho.poke_rest.model.ResponsePokemon;
import com.fsancho.poke_rest.service.PokemonService;
import com.fsancho.poke_rest.service.impl.PokemonServiceImpl;


@SpringBootTest(classes = PokeRestApplication.class)
public class PokemonServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private PokemonService pokemonService = new PokemonServiceImpl();

	@Test
	public void testSearchPokemonLazy() {
		ResponsePokemon response = new ResponsePokemon();
		Mockito.when(
				restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class), ArgumentMatchers.any(), ArgumentMatchers.<Class<ResponsePokemon>>any()))
				.thenReturn(new ResponseEntity(response, HttpStatus.OK));
		List<PokemonDTO> employee = pokemonService.searchPokemonLazy("1", "1");
		Assertions.assertEquals(response.getResults(), employee);
	}

	@Test
	public void testFindPokemonById() {
		Pokemon response = new Pokemon();
		Mockito.when(
				restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class), ArgumentMatchers.any(), ArgumentMatchers.<Class<Pokemon>>any()))
				.thenReturn(new ResponseEntity(response, HttpStatus.OK));
		Pokemon pokemon = pokemonService.findPokemonById("1");
		Assertions.assertEquals(response, pokemon);
		
		
	}

	@Test
	public void testFindEvolutions() {
		String response = new String("");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity(ArgumentMatchers.any(), ArgumentMatchers.<Class<String>>any())).thenReturn(responseEntity);
		List<EvolutionDTO> pokemon = pokemonService.findEvolutions(response);
		Assertions.assertNotNull(pokemon, "No puede ser null");

	}
}


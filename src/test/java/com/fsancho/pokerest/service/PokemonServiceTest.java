package com.fsancho.pokerest.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fsancho.poke_rest.ApplicationTest;
import com.fsancho.poke_rest.dto.EvolutionDTO;
import com.fsancho.poke_rest.dto.PokemonDTO;
import com.fsancho.poke_rest.mapper.PokemonMapper;
import com.fsancho.poke_rest.model.Abilities;
import com.fsancho.poke_rest.model.Ability;
import com.fsancho.poke_rest.model.Pokemon;
import com.fsancho.poke_rest.model.PokemonResponse;
import com.fsancho.poke_rest.model.Sprites;
import com.fsancho.poke_rest.model.Type;
import com.fsancho.poke_rest.model.Types;
import com.fsancho.poke_rest.service.PokemonService;
import com.fsancho.poke_rest.service.impl.PokemonServiceImpl;

@SpringBootTest(classes = ApplicationTest.class)
class PokemonServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private PokemonService pokemonService = new PokemonServiceImpl();

	@Spy
	private PokemonMapper pokemonMapper = Mappers.getMapper(PokemonMapper.class);


	@Test
	void testSearchPokemonLazy() {
		PokemonResponse response = new PokemonResponse();
		Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class),
				ArgumentMatchers.any(), ArgumentMatchers.<Class<PokemonResponse>>any()))
				.thenReturn(new ResponseEntity<>(response, HttpStatus.OK));
		List<PokemonDTO> employee = pokemonService.searchPokemonLazy("1", "1");
		Assertions.assertEquals(response.getResults(), employee);
	}

	@Test
	void testFindPokemonById() {
		PokemonDTO pokemonDTO = new PokemonDTO();
		pokemonDTO.setId("1");
		Pokemon pokemon = new Pokemon();
		pokemon.setId("1");

		Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class),
				ArgumentMatchers.any(), ArgumentMatchers.<Class<Pokemon>>any()))
				.thenReturn(new ResponseEntity<>(pokemon, HttpStatus.OK));

		Mockito.when(pokemonMapper.pokemonToPokemonDto(ArgumentMatchers.<Pokemon>any())).thenReturn(pokemonDTO);

		PokemonDTO pokemonDTOResul = pokemonService.findPokemonById("1");
		Assertions.assertEquals(pokemonDTOResul.getId(), pokemonDTO.getId());

	}

	@Test
	void testFindEvolutions() {
		String response = new String("");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity(ArgumentMatchers.any(), ArgumentMatchers.<Class<String>>any()))
				.thenReturn(responseEntity);
		List<EvolutionDTO> pokemon = pokemonService.findEvolutions(response);
		Assertions.assertNotNull(pokemon, "No puede ser null");

	}
}

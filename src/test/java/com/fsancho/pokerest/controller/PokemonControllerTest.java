package com.fsancho.pokerest.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.fsancho.poke_rest.ApplicationTest;


@SpringBootTest(classes = ApplicationTest.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class PokemonControllerTest {


		@LocalServerPort
		int randomServerPort;

		@Test
		void testPokemonesSuccess() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl = "http://localhost:" + randomServerPort + "/api/pokemones?offset=1&limit=1";
			URI uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			Assertions.assertEquals(200, result.getStatusCodeValue());
		}

		@Test
		void testEvolucionesSuccess() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl = "http://localhost:" + randomServerPort + "/api/evoluciones/" + 1;
			URI uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			Assertions.assertEquals(200, result.getStatusCodeValue());
		}

		@Test
		void testInformationSuccess() throws URISyntaxException {
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl = "http://localhost:" + randomServerPort + "/api/pokemon/" + 1;
			URI uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			Assertions.assertEquals(200, result.getStatusCodeValue());
		}


}
package com.fsancho.poke_rest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fsancho.poke_rest.dto.EvolutionDTO;
import com.fsancho.poke_rest.dto.PokemonDTO;
import com.fsancho.poke_rest.model.Pokemon;
import com.fsancho.poke_rest.model.PokemonResponse;
import com.fsancho.poke_rest.service.PokemonService;

/**
 * @author Fernando Sancho
 *
 */
@Service
public class PokemonServiceImpl implements PokemonService {

	private static final Logger logger = LoggerFactory.getLogger(PokemonServiceImpl.class);
	private static final String API_BASE_URL = "https://pokeapi.co/api/v2";
	private static final String API_ENDPOINT_POKEMON = "/pokemon/";
	@Autowired
	RestTemplate restTemplate;

	/**
	 * Este metodo obtiene la lista de pokemones por parametros lazy
	 */
//    @Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
	@Override
	public List<PokemonDTO> searchPokemonLazy(String offset, String limit) {
		logger.info("Obteniendo pokemones desde api - logger");
		String url = API_BASE_URL + "/pokemon?limit=" + limit + "&offset=" + offset;
		List<PokemonDTO> pokemonesDTO = new ArrayList<>();
		ResponseEntity<PokemonResponse> response = restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(),
				PokemonResponse.class);

		List<Pokemon> pokemones = response.getBody().getResults();

		for (Pokemon pokemon : pokemones) {
			pokemon = findPokemonById(API_ENDPOINT_POKEMON + getIdFromPokeUrl(pokemon.getUrl()));
			PokemonDTO pokemonDTO = new DozerBeanMapper().map(pokemon, PokemonDTO.class);
			pokemonesDTO.add(pokemonDTO);
			System.out.println(pokemonDTO);
		}
		return pokemonesDTO;
	}

//    @Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
	/**
	 * Este metodo obtiene las evoluciones
	 */
	@Override
	public List<EvolutionDTO> findEvolutions(String id) {
		String url = API_BASE_URL + id;
		List<EvolutionDTO> evoluciones = new ArrayList<>();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), String.class);
		if (response.hasBody())
			prepareEvolves(response, evoluciones);

		return evoluciones;
	}

	/**
	 * Este metodo obtiene el pokemon por id
	 */
//	@Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
	@Override
	public Pokemon findPokemonById(String id) {
		String url = API_BASE_URL + id;
		ResponseEntity<Pokemon> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(),
				Pokemon.class);
		return responseEntity.getBody();
	}

	private HttpEntity<String> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		return new HttpEntity<>("parameters", headers);
	}

	private static void prepareEvolves(ResponseEntity<String> response, List<EvolutionDTO> evoluciones) {
		JSONObject jsonObject = new JSONObject(response.getBody());
		JSONObject chain = (JSONObject) jsonObject.get("chain");
		JSONArray evolvesTo = chain.getJSONArray("evolves_to");
		loadEvolvesRecursively(evolvesTo, evoluciones);
	}

	private static void loadEvolvesRecursively(JSONArray evolvesTo, List<EvolutionDTO> evoluciones) {
		if (!evolvesTo.isEmpty()) {
			JSONObject json = evolvesTo.getJSONObject(0);
			JSONObject species = (JSONObject) json.get("species");
			evoluciones.add(new EvolutionDTO(species.getString("name")));
			JSONArray evolvesInner = json.getJSONArray("evolves_to");
			loadEvolvesRecursively(evolvesInner, evoluciones);

		}
	}

	private static String getIdFromPokeUrl(String url) {
		String[] urlSplit = url.split("/");
		return urlSplit[urlSplit.length - 1];
	}
}

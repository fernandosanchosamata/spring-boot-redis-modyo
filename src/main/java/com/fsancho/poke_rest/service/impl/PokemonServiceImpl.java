package com.fsancho.poke_rest.service.impl;

import java.util.Arrays;
import java.util.List;

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

import com.fsancho.poke_rest.model.PokemonDTO;
import com.fsancho.poke_rest.model.PokemonResponse;
import com.fsancho.poke_rest.service.PokemonService;


/**
 * @author Fernando Sancho
 *
 */
@Service
public class PokemonServiceImpl implements PokemonService{
    
    private static final String OMDB_MIME_TYPE = "application/json";
    private static final String OMDB_API_BASE_URL = "https://pokeapi.co/api/v2/pokemon";
    private static final Logger logger = LoggerFactory.getLogger(PokemonServiceImpl.class);
    
    @Autowired
    RestTemplate restTemplate;

    public PokemonServiceImpl() {
        
    }

//  @Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
    @Override
    public List<PokemonDTO> searchPokemonLazy(int offset, int limit) {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=100&offset=200";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<PokemonResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity,
                PokemonResponse.class);
        PokemonResponse results = response.getBody();
        // Map<String, List<PokemonDTO>> geonames =
        // restTemplate.getForObject(url, Map.class);
        //
        // List<PokemonDTO> data = geonames.get("results");

        return results.getResults();
    }

    @Override
    public PokemonDTO findPokemonById(int id) {
        return  null;
    }

}

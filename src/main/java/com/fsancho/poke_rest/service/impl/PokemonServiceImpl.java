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
    
    private static final String API_BASE_URL = "https://pokeapi.co/api/v2/pokemon";
    private static final Logger logger = LoggerFactory.getLogger(PokemonServiceImpl.class);
    
    @Autowired
    RestTemplate restTemplate;

    // @Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result ==
    // null")
    @Override
    public List<PokemonDTO> searchPokemonLazy(String offset, String limit) {
        logger.info("Obteniendo pokemones desde api - logger");
        System.out.println("Obteniendo pokemones desde api - systemout");
        String url = API_BASE_URL + "?limit=" + limit + "&offset=" + offset;
        HttpEntity<String> entity = getHttpEntity();
        ResponseEntity<PokemonResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, PokemonResponse.class);
        PokemonResponse results = response.getBody();
        return results.getResults();
    }

    @Override
    public PokemonDTO findPokemonById(int id) {
        return  null;
    }

    private HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return new HttpEntity<>("parameters", headers);
    }

}

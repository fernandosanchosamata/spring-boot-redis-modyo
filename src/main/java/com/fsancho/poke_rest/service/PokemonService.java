package com.fsancho.poke_rest.service;

import java.util.List;

import com.fsancho.poke_rest.model.PokemonDTO;

import reactor.core.publisher.Flux;

public interface PokemonService {
    
    PokemonDTO findPokemonById(int id);

    List<PokemonDTO> searchPokemonLazy(int offset, int limit);
}

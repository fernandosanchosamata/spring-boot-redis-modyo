package com.fsancho.poke_rest.service;

import java.util.List;

import com.fsancho.poke_rest.model.PokemonDTO;

public interface PokemonService {
    
    PokemonDTO findPokemonById(int id);

    List<PokemonDTO> searchPokemonLazy(String offset, String limit);
}

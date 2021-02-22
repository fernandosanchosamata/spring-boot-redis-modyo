package com.fsancho.poke_rest.service;

import java.util.List;

import com.fsancho.poke_rest.dto.EvolutionDTO;
import com.fsancho.poke_rest.dto.PokemonDTO;

public interface PokemonService {

    List<PokemonDTO> searchPokemonLazy(String offset, String limit);

	PokemonDTO findPokemonById(String id);

	List<EvolutionDTO> findEvolutions(String id);
}
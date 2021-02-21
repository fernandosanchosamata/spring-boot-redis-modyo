package com.fsancho.poke_rest.service;

import java.util.List;

import com.fsancho.poke_rest.dto.EvolutionDTO;
import com.fsancho.poke_rest.dto.PokemonDTO;
import com.fsancho.poke_rest.model.Pokemon;

public interface PokemonService {

    List<PokemonDTO> searchPokemonLazy(String offset, String limit);

	Pokemon findPokemonById(String id);

	List<EvolutionDTO> findEvolutions(String id);
}
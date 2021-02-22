package com.fsancho.poke_rest.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.fsancho.poke_rest.dto.PokemonDTO;
import com.fsancho.poke_rest.dto.SpritesDTO;
import com.fsancho.poke_rest.model.Abilities;
import com.fsancho.poke_rest.model.Pokemon;
import com.fsancho.poke_rest.model.Sprites;
import com.fsancho.poke_rest.model.Types;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class PokemonMapper {

	@Mapping(target = "id", source = "pokemon.id")
	@Mapping(target = "nombre", source = "pokemon.name")
	@Mapping(target = "habilidades", source = "pokemon.abilities")
	@Mapping(target = "tipos", source = "pokemon.types")
	@Mapping(target = "imagenes", source = "pokemon.sprites")
	@Mapping(target = "peso", source = "pokemon.weight")
	public abstract PokemonDTO pokemonToPokemonDto(Pokemon pokemon);

	public String[] abilitiesToAbilitiesDto(List<Abilities> abilities) {
		String[] habilidades = new String[abilities.size()];
		for (int i = 0; i < abilities.size(); i++) {
			habilidades[i] = abilities.get(i).getAbility().getName();
		}
		return habilidades;
	}

	public String[] typesToTypesDto(List<Types> types) {
		String[] tipos = new String[types.size()];
		for (int i = 0; i < types.size(); i++) {
			tipos[i] = types.get(i).getType().getName();
		}
		return tipos;
	}


	public abstract @Mapping(target = "urlimagen", source = "sprites.back_default") SpritesDTO spritesToSpritesDto(
			Sprites sprites);

}

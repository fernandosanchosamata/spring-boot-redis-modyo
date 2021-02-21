package com.fsancho.poke_rest.dto;

import java.io.Serializable;
import java.util.List;

import com.fsancho.poke_rest.model.Abilities;
import com.fsancho.poke_rest.model.Types;

/**
 * @author Fernando Sancho
 *
 */
public class PokemonDTO implements Serializable{

	private static final long serialVersionUID = 5119531849318563084L;

	private String id;

	private String name;
	private String url;

	private List<Abilities> abilities;
	private List<Types> types;

	public PokemonDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Abilities> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Abilities> abilities) {
		this.abilities = abilities;
	}

	public List<Types> getTypes() {
		return types;
	}

	public void setTypes(List<Types> types) {
		this.types = types;
	}

	public PokemonDTO(String name, String url, List<Abilities> abilities, List<Types> types) {
		super();
		this.name = name;
		this.url = url;
		this.abilities = abilities;
		this.types = types;
	}

	@Override
	public String toString() {
		return "PokemonDTO [id=" + id + ", name=" + name + ", url=" + url + ", abilities=" + abilities + ", types=" + types + "]";
	}

}

package com.fsancho.poke_rest.model;

import java.io.Serializable;
import java.util.List;


public class Pokemon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;

	private String name;
	private String url;

	private List<Abilities> abilities;
	private List<Types> types;

	private Sprites sprites;

	public Pokemon() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}

	public Pokemon(String name, String url, List<Abilities> abilities, List<Types> types) {
		super();
		this.name = name;
		this.url = url;
		this.abilities = abilities;
		this.types = types;
	}

}

package com.fsancho.poke_rest.dto;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Fernando Sancho
 *
 */
public class PokemonDTO implements Serializable {

	private static final long serialVersionUID = 5119531849318563084L;

	private String id;
	private String nombre;
	private String[] habilidades;
	private String[] tipos;
	private SpritesDTO imagenes;
	private String peso;

	public PokemonDTO() {
		super();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String[] habilidades) {
		this.habilidades = habilidades;
	}

	public String[] getTipos() {
		return tipos;
	}

	public void setTipos(String[] tipos) {
		this.tipos = tipos;
	}

	public SpritesDTO getImagenes() {
		return imagenes;
	}

	public void setImagenes(SpritesDTO imagenes) {
		this.imagenes = imagenes;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "PokemonDTO [id=" + id + ", nombre=" + nombre + ", habilidades=" + Arrays.toString(habilidades)
				+ ", tipos=" + Arrays.toString(tipos) + ", imagenes=" + imagenes + ", peso=" + peso + "]";
	}

}

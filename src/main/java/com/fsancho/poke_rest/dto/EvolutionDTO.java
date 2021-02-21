package com.fsancho.poke_rest.dto;

import java.io.Serializable;

/**
 * @author Fernando Sancho
 *
 */
public class EvolutionDTO implements Serializable{


	private static final long serialVersionUID = 5299028442271523031L;

	private String name;

	public EvolutionDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvolutionDTO other = (EvolutionDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EvolutionDTO [name=" + name + "]";
	}

}

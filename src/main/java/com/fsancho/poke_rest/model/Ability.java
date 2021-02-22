package com.fsancho.poke_rest.model;

import java.io.Serializable;

public class Ability  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4757333043836380678L;

	private String name;

	public Ability() {
		super();
	}

	public Ability(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}

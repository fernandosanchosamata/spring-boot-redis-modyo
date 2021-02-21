package com.fsancho.poke_rest.model;

import java.io.Serializable;

public class Type  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 347797775366340811L;

	private String name;

	public Type() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

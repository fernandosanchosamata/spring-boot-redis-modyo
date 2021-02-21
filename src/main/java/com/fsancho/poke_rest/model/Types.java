package com.fsancho.poke_rest.model;

import java.io.Serializable;

public class Types  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4757333043836380678L;

	private Type type;

	public Types() {
		super();
	}


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


}

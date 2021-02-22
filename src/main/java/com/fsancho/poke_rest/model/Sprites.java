package com.fsancho.poke_rest.model;

import java.io.Serializable;

public class Sprites implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7850767891865632473L;

	private String back_default;

	public Sprites() {
		super();
	}

	public Sprites(String back_default) {
		super();
		this.back_default = back_default;
	}

	public String getBack_default() {
		return back_default;
	}

	public void setBack_default(String back_default) {
		this.back_default = back_default;
	}

}

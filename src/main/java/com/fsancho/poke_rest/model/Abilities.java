package com.fsancho.poke_rest.model;

import java.io.Serializable;

public class Abilities  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4757333043836380678L;

	public Abilities() {
		super();
	}

	private Ability ability;

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

}

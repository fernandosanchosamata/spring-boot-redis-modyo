package com.fsancho.poke_rest.dto;

import java.io.Serializable;

public class SpritesDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4475222620778089749L;

	private String urlimagen;

	public SpritesDTO() {
		super();
	}

	public String getUrlimagen() {
		return urlimagen;
	}

	public void setUrlimagen(String urlimagen) {
		this.urlimagen = urlimagen;
	}

	

}

package com.fsancho.poke_rest.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class PokemonDTO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String url;

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

}

package com.fsancho.poke_rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PokemonResponse implements Serializable {
	
	
	private static final long serialVersionUID = -2648142876670348640L;

    private List<Pokemon> results;

    public PokemonResponse(){
        results = new ArrayList<>();
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

}

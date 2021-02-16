package com.fsancho.poke_rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PokemonResponse implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<PokemonDTO> results;

    public PokemonResponse(){
        results = new ArrayList<>();
    }

    public List<PokemonDTO> getResults() {
        return results;
    }

    public void setResults(List<PokemonDTO> results) {
        this.results = results;
    }

}

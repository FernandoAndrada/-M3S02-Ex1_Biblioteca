package com.M3S02Ex2.Biblioteca.service;

import com.M3S02Ex2.Biblioteca.Entity.Card;

public enum TypeCard {

    CREDITO("Crédito"),
    DEBITO("Débito");

    private String tipo;

    TypeCard (String tipo){
        this.tipo = tipo;
    }

    public String setTipo() {
        return tipo;
    }

    public void setTipo(String type) {
        this.tipo = tipo;
    }
}

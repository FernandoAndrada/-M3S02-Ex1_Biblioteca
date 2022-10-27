package com.M3S02Ex2.Biblioteca.service;

import com.M3S02Ex2.Biblioteca.Entity.Card;

public enum TypeCard {

    CREDITO("Crédito"),
    DEBITO("Débito");

    private String typeCard;

    TypeCard(String typeCard) {
        this.typeCard = typeCard;
    }
}

package com.M3S02Ex2.Biblioteca.Entity;

import com.M3S02Ex2.Biblioteca.service.TypeCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 16)
    private String number;

    private Double limite;

    private Double currentLimite;

    private TypeCard typeCard;

    //private Enum<TypeCard> tipo;

    @ManyToOne
    private Client client;

//    public Enum<TypeCard> getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(Enum<TypeCard> tipo) {
//        this.tipo = tipo;
//    }

    public static boolean isPresent() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limit) {
        this.limite = limit;
    }

    public Double getCurrentLimite() {
        return currentLimite;
    }

    public void setCurrentLimite(Double currentLimit) {
        this.currentLimite = currentLimit;
    }
}

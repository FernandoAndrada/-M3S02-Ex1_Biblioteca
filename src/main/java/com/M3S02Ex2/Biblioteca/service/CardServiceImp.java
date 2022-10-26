package com.M3S02Ex2.Biblioteca.service;
/*
import com.M3S02Ex2.Biblioteca.Entity.Card;
import com.M3S02Ex2.Biblioteca.model.CardRepository;
import com.M3S02Ex2.Biblioteca.service.interfaces.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImp implements CardService {


    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card salvar(Card card) {
        return this.cardRepository.save(card);
    }

    @Override
    public Card atualizar(Card card) {
        Optional<Card> cardPesquisado = this.cardRepository.findById(card.getId());

        if(cardPesquisado.isPresent()) {
            cardPesquisado.get().setNumber(card.getNumber());
            return this.cardRepository.save(cardPesquisado.get());
        }
        return null;
    }

    @Override
    public Card buscar(Long id) {
        Optional<Card> card = this.cardRepository.findById(id);

        if(Card.isPresent()){
            return card.get();
        }
        return null;
    }

    @Override
    public Card buscarPorNumber(String number) {
        return this.cardRepository.findByNumber(number).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um prato com o nome: " + number);
        });
    }

    @Override
    public List<Card> listar() {
        return this.cardRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        this.cardRepository.deleteById(id);

    }


}
        */
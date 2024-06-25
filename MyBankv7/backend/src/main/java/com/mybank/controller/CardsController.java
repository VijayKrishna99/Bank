package com.mybank.controller;


import com.mybank.model.Cards;
import com.mybank.repository.CardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam int id) {
        final Logger logger = LoggerFactory.getLogger(CardsController.class);
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        logger.info("Cards: {}", cards);
        return cards;
    }
}

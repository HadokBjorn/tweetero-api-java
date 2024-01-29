package com.tweetero.api.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dtos.TweetsDTO;
import com.tweetero.api.models.TweetsModel;
import com.tweetero.api.services.TweetsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {
    final TweetsService tweetService;
    TweetsController(TweetsService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetsDTO body){
        Optional<TweetsModel> tweet = tweetService.create(body);
        if (!tweet.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + body.getUserId()+ " does not exist");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }
}

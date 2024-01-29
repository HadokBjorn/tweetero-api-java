package com.tweetero.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweetero.api.dtos.TweetsDTO;
import com.tweetero.api.models.TweetsModel;
import com.tweetero.api.models.UsersModel;
import com.tweetero.api.repositories.TweetsRepository;
import com.tweetero.api.repositories.UsersRepository;

@Service
public class TweetsService {
    final TweetsRepository tweetRepository;
    final UsersRepository userRepository;
    TweetsService(TweetsRepository tweetRepository, UsersRepository userRepository){
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Optional<TweetsModel> create(TweetsDTO dto){
        Optional<UsersModel> user = userRepository.findById(dto.getUserId());
        if(!user.isPresent()){
            return Optional.empty();
        }
        TweetsModel tweet = new TweetsModel(dto, user.get());
        return Optional.of(tweetRepository.save(tweet));
    }

    public List<TweetsModel> findTweetsByUser(Long id){
        return tweetRepository.findTweetsByUserId(id);
    }
}

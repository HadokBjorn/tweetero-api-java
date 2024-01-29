package com.tweetero.api.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweetero.api.dtos.UsersDTO;
import com.tweetero.api.models.UsersModel;
import com.tweetero.api.repositories.UsersRepository;

@Service
public class UsersService {
    final UsersRepository userRepository;
    UsersService(UsersRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<UsersModel> create( UsersDTO dto){
        if(userRepository.existsByUsername(dto.getUsername())){
            return Optional.empty();
        }
        UsersModel user = new UsersModel(dto);
        return Optional.of(userRepository.save(user));
    }
}

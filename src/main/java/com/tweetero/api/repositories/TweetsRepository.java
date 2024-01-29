package com.tweetero.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetero.api.models.TweetsModel;

@Repository
public interface TweetsRepository extends JpaRepository<TweetsModel, Long> {}

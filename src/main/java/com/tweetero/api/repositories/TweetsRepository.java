package com.tweetero.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweetero.api.models.TweetsModel;

@Repository
public interface TweetsRepository extends JpaRepository<TweetsModel, Long> {
    @Query(value = "SELECT * FROM tweets WHERE user_id = :userId", nativeQuery = true)
    List<TweetsModel> findTweetsByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM tweets ORDER BY tweets.id DESC", nativeQuery = true)
    List<TweetsModel> findTweetsOrdened();


}

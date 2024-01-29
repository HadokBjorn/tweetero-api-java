package com.tweetero.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tweetero.api.models.UsersModel;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    boolean existsByUsername(String username);
}

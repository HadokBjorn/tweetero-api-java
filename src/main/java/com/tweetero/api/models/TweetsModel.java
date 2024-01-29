package com.tweetero.api.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.tweetero.api.dtos.TweetsDTO;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tweets")
public class TweetsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(length = 280, nullable = false)
    private String tweet;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UsersModel user;

    public TweetsModel(TweetsDTO dto, UsersModel user){
        this.tweet = dto.getTweet();
        this.user = user;
    }
}

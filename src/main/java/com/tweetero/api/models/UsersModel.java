package com.tweetero.api.models;
import com.tweetero.api.dtos.UsersDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String avatar;

    @Column(length = 100,nullable = false, unique = true)
    private String username;

    public UsersModel(UsersDTO user){
        this.avatar = user.getAvatar();
        this.username = user.getUsername();
    }
}

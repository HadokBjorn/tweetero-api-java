package com.tweetero.api.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsersDTO {
    @NotBlank(message = "avatar cannot be null or empty")
    private String avatar;
    
    @NotBlank
    @Size(min = 2,max = 100, message = "username must be at least 2 characters")
    private String username;
}

package com.tweetero.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetsDTO {
    @NotNull
    private Long userId;

    @NotBlank
    @Size(max = 280)
    private String tweet;
}

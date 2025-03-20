package org.example.expert.domain.user.dto.response;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String email;
    private String signedUrl;

    public UserResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public UserResponse(Long id, String email, @Nullable String signedUrl) {
        this.id = id;
        this.email = email;
        this.signedUrl = signedUrl;
    }
}

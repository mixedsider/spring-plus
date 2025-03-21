package org.example.expert.domain.user.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.user.entity.User;

@Getter
@NoArgsConstructor
public class UserSearchResponse {

    private Long id;
    private String email;
    private String nickname;
    private String searchTime;

    public UserSearchResponse(Long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    public UserSearchResponse(Long id, String email, String nickname, String searchTime) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.searchTime = searchTime;
    }

    public static UserSearchResponse of(User user, String searchTime) {
        return new UserSearchResponse(user.getId(), user.getEmail(), user.getNickname(), searchTime);
    }
}

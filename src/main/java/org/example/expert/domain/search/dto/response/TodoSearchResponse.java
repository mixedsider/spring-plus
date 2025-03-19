package org.example.expert.domain.search.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoSearchResponse {
    private String title;
    private Integer managerCount;
    private Integer commentCount;

    public TodoSearchResponse(String title, Integer managerCount, Integer commentCount) {
        this.title = title;
        this.managerCount = managerCount;
        this.commentCount = commentCount;
    }
}

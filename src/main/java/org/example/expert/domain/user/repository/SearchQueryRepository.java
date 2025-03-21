package org.example.expert.domain.user.repository;

import org.example.expert.domain.user.entity.User;

public interface SearchQueryRepository {

    User findByNicknameWithQueryDsl(String nickname);
}

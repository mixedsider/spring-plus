package org.example.expert.domain.user.repository;

import org.example.expert.domain.user.entity.User;

import java.util.List;

public interface SearchQueryRepository {

    User findByNicknameWithQueryDsl(String nickname);

    List<User> findByNicknameWithQueryDslIndex(String nickname);
}

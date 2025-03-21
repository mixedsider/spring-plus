package org.example.expert.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.user.entity.User;

import static org.example.expert.domain.user.entity.QUser.user;

@RequiredArgsConstructor
public class SearchQueryRepositoryImpl implements SearchQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public User findByNicknameWithQueryDsl(String nickname) {
        return queryFactory
                .selectFrom(user)
                .where(user.nickname.eq(nickname))
                .fetchOne();
    }
}

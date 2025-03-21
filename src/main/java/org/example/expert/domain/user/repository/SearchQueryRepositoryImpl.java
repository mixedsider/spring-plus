package org.example.expert.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.user.entity.User;

import java.util.List;

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

    @Override
    public List<User> findByNicknameWithQueryDslIndex(String nickname) {
        return queryFactory
                .select(user)
                .from(user)
                .where(user.nickname.eq(nickname))
                .fetch();
    }
}

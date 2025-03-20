package org.example.expert.domain.search.repository.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.search.dto.response.TodoSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.example.expert.domain.todo.entity.QTodo.todo;


@RequiredArgsConstructor
public class TodoSearchRepositoryQueryImpl implements TodoSearchRepositoryQuery {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<TodoSearchResponse> search(String title, LocalDate startDate, LocalDate endDate, String nickname, Pageable pageable) {

        List<TodoSearchResponse> todoList = queryFactory
                .select(Projections
                        .constructor(
                                TodoSearchResponse.class,
                                todo.title,
                                todo.managers.size(),
                                todo.comments.size()
                        ))
                .from(todo)
                .where(conditionTitle(title),
                        conditionDate(startDate, endDate),
                        conditionNickname(nickname)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long count = queryFactory
                .select(todo.count())
                .from(todo)
                .leftJoin(todo.user)
                .where(
                        conditionTitle(title),
                        conditionDate(startDate, endDate),
                        conditionNickname(nickname)
                )
                .fetch().size();

        return new PageImpl<>(todoList, pageable, count);
    }

    private BooleanExpression conditionNickname(String nickname) {
        if( nickname == null || nickname.isEmpty() ) {
            return null;
        }
        return todo.user.nickname.contains(nickname);
    }

    private BooleanExpression conditionTitle(String title) {
        if( title == null || title.isEmpty() ) {
            return null;
        }
        return todo.title.contains(title);
    }

    private BooleanExpression conditionDate(LocalDate startDate, LocalDate endDate) {
        if( startDate == null ) {
            return null;
        }

        return todo.createdAt.between(parseLocalDateTime(startDate), parseLocalDateTime(endDate));
    }

    private LocalDateTime parseLocalDateTime(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MIN);
    }
}

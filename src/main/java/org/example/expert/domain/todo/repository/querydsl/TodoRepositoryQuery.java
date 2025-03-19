package org.example.expert.domain.todo.repository.querydsl;

import org.example.expert.domain.todo.entity.Todo;

import java.util.Optional;

public interface TodoRepositoryQuery {

    Optional<Todo> findByIdWithUser(Long todoId);
}

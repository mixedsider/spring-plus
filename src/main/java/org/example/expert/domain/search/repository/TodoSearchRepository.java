package org.example.expert.domain.search.repository;

import org.example.expert.domain.search.repository.querydsl.TodoSearchRepositoryQuery;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoSearchRepository extends JpaRepository<Todo, Long>, TodoSearchRepositoryQuery {
}

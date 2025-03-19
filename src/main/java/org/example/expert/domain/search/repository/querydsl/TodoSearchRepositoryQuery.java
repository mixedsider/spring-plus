package org.example.expert.domain.search.repository.querydsl;

import org.example.expert.domain.search.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TodoSearchRepositoryQuery {
    Page<TodoSearchResponse> search(String title, LocalDate startDate, LocalDate endDate, String nickname, Pageable pageable);
}

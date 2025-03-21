package org.example.expert.domain.search.repository.querydsl;

import org.example.expert.domain.search.dto.response.TodoSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface TodoSearchRepositoryQuery {
    Page<TodoSearchResponse> search(String title, LocalDate startDate, LocalDate endDate, String nickname, Pageable pageable);
}

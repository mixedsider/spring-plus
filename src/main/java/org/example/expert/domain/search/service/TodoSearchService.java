package org.example.expert.domain.search.service;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.search.dto.response.TodoSearchResponse;
import org.example.expert.domain.search.repository.TodoSearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoSearchService {

    private final TodoSearchRepository todoSearchRepository;

    public Page<TodoSearchResponse> search(int page, int size, String title, LocalDate startDate, LocalDate endDate, String nickname) {

        Pageable pageable = PageRequest.of(page - 1, size);

        return todoSearchRepository.search(title, startDate, endDate, nickname, pageable);
    }



}

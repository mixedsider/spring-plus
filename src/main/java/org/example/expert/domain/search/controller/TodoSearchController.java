package org.example.expert.domain.search.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.search.dto.response.TodoSearchResponse;
import org.example.expert.domain.search.service.TodoSearchService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoSearchController {

    private final TodoSearchService todoSearchService;

    @GetMapping("/v1/search")
    public ResponseEntity<Page<TodoSearchResponse>> searchTodo(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "startDate", required = false) LocalDate startDate,
            @RequestParam(name = "endDate", required = false) LocalDate endDate,
            @RequestParam(name = "nickname", required = false) String nickname
    ) {
        Page<TodoSearchResponse> searched = todoSearchService.search(page, size, title, startDate, endDate, nickname);
        return new ResponseEntity<>(searched, HttpStatus.OK);
    }
}

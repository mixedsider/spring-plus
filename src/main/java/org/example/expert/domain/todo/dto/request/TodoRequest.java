package org.example.expert.domain.todo.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class TodoRequest {

    @Positive
    private int page = 1;

    @Positive
    private int size = 10;

    @Nullable
    private String weather;

    @Nullable
    private LocalDate startDate = LocalDate.MIN;

    @Nullable
    private LocalDate endDate = LocalDate.MAX;

    public TodoRequest( int page, int size, @Nullable String weather, @Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        this.page = page;
        this.size = size;
        this.weather = weather;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

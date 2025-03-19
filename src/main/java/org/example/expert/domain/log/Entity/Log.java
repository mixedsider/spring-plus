package org.example.expert.domain.log.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.common.entity.Timestamped;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "log")
public class Log extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 순수 기록용으로 유저 아이디만 남겼음
    private Long userId; // 일정만든 유저 User.class

    private Long managerId; // 매니저 되는 유저 User.class

    private Long todoId; // 등록되는 일정 Todo.class



    public Log (Long userId, Long managerId, Long todoId) {
        this.userId = userId;
        this.managerId = managerId;
        this.todoId = todoId;
    }
}

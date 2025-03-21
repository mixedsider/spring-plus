package org.example.expert.domain.user.service;

import jakarta.persistence.EntityManager;
import org.example.expert.domain.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles({"dev"})
@Transactional
@Commit
class UserServiceTest {

    private static final int BATCH_SIZE = 1000;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager em;

    @Test
    void beforeAll() {
        String word =
                "가,나,다,라,마,바,사,아,자,차," +
                "카,타,파,하,거,너,더,머,버,서," +
                "어,저,처,커,터,퍼,허,고,노,도," +
                "모,보,소,오,조,초,코,토,포,호," +
                "구,누,두,무,부,수,우,주,추,쿠," +
                "투,푸,후,그,느,드,므,브,스,어," +
                "저,처,커,터,퍼,허,기,니,디,미," +
                "비,시,이,지,치,키,티,피,히,간," +
                "날,달,갈,말,발,살,알,잘,찰,칼," +
                "탈,팔,할,걱,넋,덕,먹,벅,섯,엇," +
                "한,둘,셋,넷,닷";

        String[] words = word.split(",");

        int total = 1000000;

        List<User> users = new ArrayList<>();

        String sql = "INSERT INTO users (email, nickname) VALUES (?,?)";

        for( int i = 0; i < total; i++ ) {
            String email = String.format("testEmail%d@testemail.com", i);
            String nickname = String.format("%s%s%s%s%s%s",
                    words[(int) (Math.random() * words.length)],
                    words[(int) (Math.random() * words.length)],
                    words[(int) (Math.random() * words.length)],
                    words[(int) (Math.random() * words.length)],
                    words[(int) (Math.random() * words.length)],
                    words[(int) (Math.random() * words.length)]
            );
            User user = new User();
            ReflectionTestUtils.setField(user, "email", email);
            ReflectionTestUtils.setField(user, "nickname", nickname);
            users.add(user);
        }

        jdbcTemplate.batchUpdate(sql, users, BATCH_SIZE, ((ps, argument) -> {
            ps.setString(1, argument.getEmail());
            ps.setString(2, argument.getNickname());
        }));
    }
}
package com.yalmung.mini.commerce.user;

import com.yalmung.mini.commerce.user.model.User;
import com.yalmung.mini.commerce.user.model.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    public final User YALMUNG = User.of("yalmung", "얄뭉");

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("사용자를 저장할 수 있어야 한다.")
    @Rollback(false)
    void save_user() {
        User user = userRepository.save(YALMUNG);


        assertAll(
                () -> assertThat(user.getId()).isEqualTo(YALMUNG.getId()),
                () -> assertThat(user.getName()).isEqualTo(YALMUNG.getName()),
                () -> assertThat(user.getDelYn()).isNotNull()
        );
    }

}

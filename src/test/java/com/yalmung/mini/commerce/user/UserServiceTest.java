package com.yalmung.mini.commerce.user;

import com.yalmung.mini.commerce.user.application.UserService;
import com.yalmung.mini.commerce.user.model.User;
import com.yalmung.mini.commerce.user.model.UserCondition;
import com.yalmung.mini.commerce.user.model.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    public final User YALMUNG = User.of(1, "yalmung", "얄뭉", "N");
    public final User BBASHONG = User.of(2, "bbashong", "빠숑", "N");
    public final User HONGYA = User.of(3, "hongya", "홍야", "Y");
    private List<User> users;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        users = List.of(YALMUNG, BBASHONG, HONGYA);

    }

    @Test
    @DisplayName("사용자 필드와 오퍼레이터로 조건에 맞는 사용자를 추출할 수 있다.")
    void filterByNameEquals() {
        List<User> filteredUsers = users.stream()
                .filter(userService.chekUser("name", "얄뭉", "="))
                .toList();

        assertAll(
                () -> assertEquals(1, filteredUsers.size()),
                () -> assertTrue(filteredUsers.stream().allMatch(u -> u.getName().equals("얄뭉")))
        );
    }

    @Test
    @DisplayName("no가 2 이상인 사용자를 추출할 수 있다")
    void filterByUserNoGts() {
        List<User> filteredUsers = users.stream()
                .filter(userService.chekUser("userNo", "2", ">="))
                .toList();

        assertAll(
                () -> assertEquals(2, filteredUsers.size()),
                () -> assertTrue(filteredUsers.stream().allMatch(u -> u.getUserNo() >= 2))
        );
    }

}

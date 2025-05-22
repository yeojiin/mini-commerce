package com.yalmung.mini.commerce.user.application;

import com.yalmung.mini.commerce.user.model.User;
import com.yalmung.mini.commerce.user.model.UserCondition;
import com.yalmung.mini.commerce.user.model.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.function.Predicate;

@Service
@Transactional(readOnly = true)
public class UserService implements UserCondition {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Predicate<User> chekUser(String field, String value, String operator) {
        // Predicate<T> 는 User을 파라미터로 받는 함수형 인터페이스
        return user -> {    // user는 Predicate<User>.test(user)의 매개변수
            try {
                Field userField = User.class.getDeclaredField(field);
                userField.setAccessible(true);      // private 필드 접근 가능하도록 설정

                Object fieldValue = userField.get(user);

                if(fieldValue instanceof String strVal) {
                    return compareString(strVal, value, operator);
                } else if(fieldValue instanceof  Integer intVal) {
                    return compareInt(intVal, Integer.parseInt(value), operator);
                }

                return false;
            } catch (Exception e) {
                // 예외 발생 시 false (존재하지 않는 필드 등)
                return false;
            }
        };
    }

    private boolean compareInt(Integer fieldVal, int value, String operator) {
        return switch (operator) {
            case "=" -> fieldVal == value;
            case ">" -> fieldVal > value;
            case ">=" -> fieldVal >= value;
            case "<" -> fieldVal < value;
            case "<=" -> fieldVal <= value;
            default -> false;
        };
    }

    private boolean compareString(String fieldVal, String value, String operator) {
        return "=".equals(operator) && fieldVal.equals(value);
    }
}

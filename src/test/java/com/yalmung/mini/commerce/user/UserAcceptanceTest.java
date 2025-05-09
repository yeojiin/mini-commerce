package com.yalmung.mini.commerce.user;

import com.yalmung.mini.commerce.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 관련 기능")
public class UserAcceptanceTest extends AcceptanceTest {
    private static final String id = "yalmung";
    private static final String name = "얄뭉";

    @DisplayName("사용자를 생성한다")
    @Test
    void createUser() {

    }
}

package tybms.co.kr.admin.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class PasswordTest {

    public static final String ENCODED_PASSWORD = "encoded password";

    @DisplayName("PasswordEncoder로 변환한 패스워드를 set ")
    @Test
    void setEncodePassword() {
        Password password = Password.builder()
                .password("password")
                .build();
        PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
        given(passwordEncoder.encode(any())).willReturn(ENCODED_PASSWORD);

        password.setEncodePassword(passwordEncoder);

        assertThat(password.getPassword()).isEqualTo(ENCODED_PASSWORD);
    }
}

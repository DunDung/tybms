package co.kr.tybms.admin.service;

import co.kr.tybms.admin.entity.Password;
import co.kr.tybms.admin.repository.PasswordRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PasswordServiceTest {

    public static final String PASSWORD = "password";
    public static final String ANOTHER_PASSWORD = "password2";

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Password password;

    @BeforeEach
    void setUp() {
        password = Password.builder()
                .password(PASSWORD)
                .build();
    }

    @DisplayName("패스워드가 일치하는 경우")
    @Test
    void isMatchPassword() {
        password.setEncodePassword(passwordEncoder);
        passwordRepository.save(password);
        Password matchedPassword = Password.builder()
                .password(PASSWORD)
                .build();

        boolean result = passwordService.isMatch(matchedPassword);

        assertThat(result).isTrue();
    }

    @DisplayName("패스워드가 일치하지 않는 경우")
    @Test
    void isNotMatchPassword() {
        password.setEncodePassword(passwordEncoder);
        passwordRepository.save(password);
        Password notMatchedPassword = Password.builder()
                .password(ANOTHER_PASSWORD)
                .build();

        boolean result = passwordService.isMatch(notMatchedPassword);

        assertThat(result).isFalse();
    }

    @DisplayName("패스워드 등록")
    @Test
    void register() {
        Password register = passwordService.register(password);

        Password find = passwordRepository.findById(register.getId())
                .orElseThrow(NoSuchElementException::new);
        assertThat(register).usingRecursiveComparison()
                .isEqualTo(find);
    }

    @AfterEach
    void tearDown() {
        passwordRepository.deleteAll();
    }
}
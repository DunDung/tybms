package com.tybms.admin.service;

import com.tybms.admin.entity.Password;
import com.tybms.admin.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PasswordService {

    private static final long ONLY_ONE_PASSWORD_ID = 1L;

    private final PasswordRepository passwordRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean isMatch(Password password) {
        Password inFactEncodedPassword = this.passwordRepository.findById(ONLY_ONE_PASSWORD_ID)
                .orElseThrow(() -> new RuntimeException("NOT EXIST PASSWORD ID"));
        return this.passwordEncoder.matches(password.getPassword(), inFactEncodedPassword.getPassword());
    }

    public Password register(Password password) {
        password.encodePassword(this.passwordEncoder);
        return passwordRepository.save(password);
    }
}

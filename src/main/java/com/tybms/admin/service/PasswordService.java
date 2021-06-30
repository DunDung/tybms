package com.tybms.admin.service;

import com.tybms.admin.entity.Password;
import com.tybms.admin.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PasswordService {

    private final PasswordRepository passwordRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean isMatch(Password password) {
        return this.passwordRepository.findAll().stream()
                .map(Password::getPassword)
                .anyMatch(realPassword -> this.passwordEncoder.matches(password.getPassword(), realPassword));
    }

    public Password register(Password password) {
        password.encodePassword(this.passwordEncoder);
        return passwordRepository.save(password);
    }
}

package co.kr.tybms.admin.api;

import co.kr.tybms.admin.entity.Password;
import co.kr.tybms.admin.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/passwords")
public class PasswordApiController {

    private final PasswordService passwordService;

    @PostMapping
    public ResponseEntity<Boolean> isMatch(@RequestBody Password password) {
        return ResponseEntity.ok(passwordService.isMatch(password));
    }
}

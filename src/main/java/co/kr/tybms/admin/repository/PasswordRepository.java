package co.kr.tybms.admin.repository;

import co.kr.tybms.admin.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}

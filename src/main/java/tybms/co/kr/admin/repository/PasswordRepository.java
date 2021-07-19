package tybms.co.kr.admin.repository;

import tybms.co.kr.admin.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}

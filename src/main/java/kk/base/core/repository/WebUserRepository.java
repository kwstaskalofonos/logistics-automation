package kk.base.core.repository;

import kk.base.core.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {

    Optional<WebUser> findByUsername(String username);
}

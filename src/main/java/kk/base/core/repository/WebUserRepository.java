package kk.base.core.repository;

import kk.base.core.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
}

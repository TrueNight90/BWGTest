package org.yjr.login.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yjr.login.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}

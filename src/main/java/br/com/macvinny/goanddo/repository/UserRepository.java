package br.com.macvinny.goanddo.repository;

import br.com.macvinny.goanddo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByActiveTrue();
    User findByEmail(String email);
}

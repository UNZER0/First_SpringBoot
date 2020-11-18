package springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.demo.domain.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByAccount(String account);
}

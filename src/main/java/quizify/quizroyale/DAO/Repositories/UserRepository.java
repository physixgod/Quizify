package quizify.quizroyale.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quizify.quizroyale.DAO.Entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);
}

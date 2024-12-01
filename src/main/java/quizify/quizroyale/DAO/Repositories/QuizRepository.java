package quizify.quizroyale.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quizify.quizroyale.DAO.Entities.Quiz;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}

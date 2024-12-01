package quizify.quizroyale.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quizify.quizroyale.DAO.Entities.Question;
import quizify.quizroyale.DAO.Enums.DifficultyLevel;
import quizify.quizroyale.DAO.Enums.QuestionCategory;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> getQuestionsByDifficultyLevel(DifficultyLevel difficultyLevel);
    List<Question> getQuestionsByQuestionCategory(QuestionCategory questionCategory);
}

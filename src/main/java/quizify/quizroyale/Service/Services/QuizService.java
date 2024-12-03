package quizify.quizroyale.Service.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import quizify.quizroyale.DAO.Entities.Question;
import quizify.quizroyale.DAO.Entities.Quiz;
import quizify.quizroyale.DAO.Repositories.QuestionRepository;
import quizify.quizroyale.DAO.Repositories.QuizRepository;
import quizify.quizroyale.Service.Interfaces.IQuizService;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class QuizService implements IQuizService {
    QuizRepository quizRepository;
    QuestionRepository questionRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        if (quiz == null) {
            throw new IllegalArgumentException("Quiz cannot be null.");
        }
        quiz.setCreatedDate(LocalDateTime.now());
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        if (quiz == null) {
            throw new IllegalArgumentException("Quiz cannot be null.");
        }
        quiz.setUpdatedDate(LocalDateTime.now());
        return quizRepository.save(quiz);    }

    @Override
    public void addQuestionToQuiz(int idQuiz, int idQuestion) {
        Question  question = questionRepository.findById(idQuestion).orElse(null);
        Quiz quiz = quizRepository.findById(idQuiz).orElse(null);
        if (question != null && quiz != null){
            quiz.getQuestions().add(question);
            quizRepository.save(quiz);
        }
    }

    @Override
    public void removeQuestionFromQuiz(int idQuiz, int idQuestion) {
        Question  question = questionRepository.findById(idQuestion).orElse(null);
        Quiz quiz = quizRepository.findById(idQuiz).orElse(null);
        if (question != null && quiz != null){
            quiz.getQuestions().remove(question);
            quizRepository.save(quiz);
        }
    }

    @Override
    public void deleteQuiz(int idQuiz) {
        Quiz quiz = quizRepository.findById(idQuiz).orElse(null);
        if (quiz != null){
            for (Question question:quiz.getQuestions()){
                quiz.getQuestions().remove(question);
            }
            quizRepository.delete(quiz);
        }
    }
}

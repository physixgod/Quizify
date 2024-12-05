package quizify.quizroyale.Service.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import quizify.quizroyale.DAO.Entities.Question;
import quizify.quizroyale.DAO.Entities.Quiz;
import quizify.quizroyale.DAO.Entities.User;
import quizify.quizroyale.DAO.Repositories.QuestionRepository;
import quizify.quizroyale.DAO.Repositories.QuizRepository;
import quizify.quizroyale.DAO.Repositories.UserRepository;
import quizify.quizroyale.Service.Interfaces.IQuizService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class QuizService implements IQuizService {
    QuizRepository quizRepository;
    QuestionRepository questionRepository;
    UserRepository userRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        if (quiz == null) {
            throw new IllegalArgumentException("Quiz cannot be null.");
        }
        quiz.setCreatedDate(LocalDateTime.now());
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz addQuizByUser(Quiz quiz, Integer idUser) {
        if (quiz == null) {
            throw new IllegalArgumentException("Question cannot be null.");
        }
        User user= userRepository.findById(idUser).orElse(null);
        if (user != null) {
            quiz.setCreatedDate(LocalDateTime.now());
            user.getQuizzes().add(quiz);
            userRepository.save(user);
        }
        return quiz;
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

    @Override
    public Set<Quiz> showAllQuiz() {
        return  new HashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz findQuizByid(int id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Question> showQuizQuestions(int id) {
        return Objects.requireNonNull(quizRepository.findById(id).orElse(null)).getQuestions();
    }

    @Override
    public Set<Question> showQuizNotAffectedQuestions(int id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        Set<Question> questionsNotAffected = new HashSet<>();
        if ( quiz != null) {
            Set<Question> questionsAffected = quiz.getQuestions();
            Set<Question> allQuestions= new HashSet<>(questionRepository.findAll());
            for (Question question:allQuestions){
                if (!questionsAffected.contains(question)){
                    questionsNotAffected.add(question);
                }
            }
        }
        return questionsNotAffected;
    }
}

package quizify.quizroyale.Service.Services;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import quizify.quizroyale.DAO.Entities.Question;
import quizify.quizroyale.DAO.Enums.DifficultyLevel;
import quizify.quizroyale.DAO.Enums.QuestionCategory;
import quizify.quizroyale.DAO.Repositories.QuestionRepository;
import quizify.quizroyale.DAO.Repositories.QuizRepository;
import quizify.quizroyale.Service.Interfaces.IQuestionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {
    QuestionRepository questionRepository;
    QuizRepository quizRepository;

    @Override
    public Question addQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null.");
        }
        question.setCreatedDate(LocalDateTime.now());
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null.");
        }
        question.setUpdateDate(LocalDateTime.now());
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllEasyQuestions() {
        return questionRepository.getQuestionsByDifficultyLevel(DifficultyLevel.EASY);
    }

    @Override
    public List<Question> getAllMediumQuestions() {
        return questionRepository.getQuestionsByDifficultyLevel(DifficultyLevel.MEDIUM);
    }

    @Override
    public List<Question> getAllHardQuestions() {
        return questionRepository.getQuestionsByDifficultyLevel(DifficultyLevel.HARD);
    }

    private final Random random = new Random();
    @Override
    public Question generateRandomQuestion() {
        List<Question> allQuestions=getAllQuestions();
        int i =random.nextInt(allQuestions.size());
        return allQuestions.get(i);
    }

    @Override
    public List<Question> generateMATHSQuestions() {
        return questionRepository.getQuestionsByQuestionCategory(QuestionCategory.MATHS);
    }

    @Override
    public Question generateRandomMATHSQuestion() {
        List<Question> allQuestions=generateMATHSQuestions();
        int i =random.nextInt(allQuestions.size());
        return allQuestions.get(i);
    }

    @Override
    public List<Question> generateEasyRandomMATHSQuestion() {
        return null;
    }

    @Override
    public List<Question> generateMediumRandomMATHSQuestion() {
        return null;
    }

    @Override
    public List<Question> generateHardRandomMATHSQuestion() {
        return null;
    }

    @Override
    public List<Question> generateHISTORYQuestions() {
        return null;
    }

    @Override
    public Question generateRandomHISTORYQuestion() {
        return null;
    }

    @Override
    public List<Question> generateEasyRandomHISTORYQuestion() {
        return null;
    }

    @Override
    public List<Question> generateMediumRandomHISTORYQuestion() {
        return null;
    }

    @Override
    public List<Question> generateHardRandomHISTORYQuestion() {
        return null;
    }

    @Override
    public List<Question> generateGEOGRAPHYQuestions() {
        return null;
    }

    @Override
    public Question generateRandomGEOGRAPHYQuestion() {
        return null;
    }

    @Override
    public List<Question> generateEasyRandomGEOGRAPHYQuestion() {
        return null;
    }

    @Override
    public List<Question> generateMediumRandomGEOGRAPHYQuestion() {
        return null;
    }

    @Override
    public List<Question> generateHardRandomGEOGRAPHYQuestion() {
        return null;
    }

    @Override
    public List<Question> generateLITERATUREQuestions() {
        return null;
    }

    @Override
    public Question generateRandomLITERATUREQuestion() {
        return null;
    }

    @Override
    public List<Question> generateEasyRandomLITERATUREQuestion() {
        return null;
    }

    @Override
    public List<Question> generateMediumRandomLITERATUREQuestion() {
        return null;
    }

    @Override
    public List<Question> generateHardRandomLITERATUREQuestion() {
        return null;
    }

    @Override
    public List<Question> generateSPORTQuestions() {
        return null;
    }

    @Override
    public Question generateRandomSPORTQuestion() {
        return null;
    }

    @Override
    public List<Question> generateEasyRandomSPORTQuestion() {
        return null;
    }

    @Override
    public List<Question> generateMediumRandomSPORTQuestion() {
        return null;
    }

    @Override
    public List<Question> generateHardRandomSPORTQuestion() {
        return null;
    }

    @Override
    public Question deleteQuestion(int idQuestion) {
        return null;
    }
}

package quizify.quizroyale.Service.Services;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import quizify.quizroyale.DAO.Entities.Question;
import quizify.quizroyale.DAO.Entities.Quiz;
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
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.MATHS,DifficultyLevel.EASY);


    }

    @Override
    public List<Question> generateMediumRandomMATHSQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.MATHS,DifficultyLevel.MEDIUM);
    }

    @Override
    public List<Question> generateHardRandomMATHSQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.MATHS,DifficultyLevel.EASY);

    }

    @Override
    public List<Question> generateHISTORYQuestions() {
        return questionRepository.getQuestionsByQuestionCategory(QuestionCategory.HISTORY);
    }

    @Override
    public Question generateRandomHISTORYQuestion() {
        List<Question> allQuestions=generateHISTORYQuestions();
        int i =random.nextInt(allQuestions.size());
        return allQuestions.get(i);
    }

    @Override
    public List<Question> generateEasyRandomHISTORYQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.HISTORY,DifficultyLevel.EASY);
    }

    @Override
    public List<Question> generateMediumRandomHISTORYQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.HISTORY,DifficultyLevel.MEDIUM);
    }

    @Override
    public List<Question> generateHardRandomHISTORYQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.HISTORY,DifficultyLevel.HARD);

    }

    @Override
    public List<Question> generateGEOGRAPHYQuestions() {
        return questionRepository.getQuestionsByQuestionCategory(QuestionCategory.GEOGRAPHY);
    }

    @Override
    public Question generateRandomGEOGRAPHYQuestion() {
        List<Question> allQuestions=generateGEOGRAPHYQuestions();
        int i =random.nextInt(allQuestions.size());
        return allQuestions.get(i);
    }

    @Override
    public List<Question> generateEasyRandomGEOGRAPHYQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.GEOGRAPHY,DifficultyLevel.EASY);
    }

    @Override
    public List<Question> generateMediumRandomGEOGRAPHYQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.GEOGRAPHY,DifficultyLevel.MEDIUM);
    }

    @Override
    public List<Question> generateHardRandomGEOGRAPHYQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.GEOGRAPHY,DifficultyLevel.HARD);
    }

    @Override
    public List<Question> generateLITERATUREQuestions() {
        return questionRepository.getQuestionsByQuestionCategory(QuestionCategory.LITERATURE);
    }


    @Override
    public Question generateRandomLITERATUREQuestion() {
        List<Question> allQuestions=generateLITERATUREQuestions();
        int i =random.nextInt(allQuestions.size());
        return allQuestions.get(i);
    }

    @Override
    public List<Question> generateEasyRandomLITERATUREQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.LITERATURE,DifficultyLevel.EASY);
    }

    @Override
    public List<Question> generateMediumRandomLITERATUREQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.LITERATURE,DifficultyLevel.MEDIUM);
    }

    @Override
    public List<Question> generateHardRandomLITERATUREQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.LITERATURE,DifficultyLevel.HARD);
    }

    @Override
    public List<Question> generateSPORTQuestions() {
        return questionRepository.getQuestionsByQuestionCategory(QuestionCategory.SPORT);
    }

    @Override
    public Question generateRandomSPORTQuestion() {
        List<Question> allQuestions=generateSPORTQuestions();
        int i =random.nextInt(allQuestions.size());
        return allQuestions.get(i);
    }
    @Override
    public List<Question> generateEasyRandomSPORTQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.SPORT,DifficultyLevel.EASY);
    }
    @Override
    public List<Question> generateMediumRandomSPORTQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.SPORT,DifficultyLevel.MEDIUM);
    }
    @Override
    public List<Question> generateHardRandomSPORTQuestion() {
        return questionRepository.getQuestionsByQuestionCategoryAndDifficultyLevel(QuestionCategory.SPORT,DifficultyLevel.HARD);
    }
    @Override
    public void deleteQuestion(int idQuestion) {
        Question qs=questionRepository.findById(idQuestion).orElse(null);
        List<Quiz> quizList = quizRepository.findAll();
        for (Quiz q:quizList) {
            for (Question question : q.getQuestions()) {
                if (question == qs) {
                    q.getQuestions().remove(qs);
                    quizRepository.save(q);
                }
            }
        }
        questionRepository.deleteById(idQuestion);
    }
}

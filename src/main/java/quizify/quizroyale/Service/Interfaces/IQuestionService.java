package quizify.quizroyale.Service.Interfaces;

import quizify.quizroyale.DAO.Entities.Question;

import java.util.List;

public interface IQuestionService {
    Question addQuestion(Question question);
    Question updateQuestion(Question question);
    List<Question> getAllQuestions();
    List<Question> getAllEasyQuestions();
    List<Question> getAllMediumQuestions();
    List<Question> getAllHardQuestions();
    Question generateRandomQuestion();
    List<Question> generateMATHSQuestions();
    Question generateRandomMATHSQuestion();
    List<Question> generateEasyRandomMATHSQuestion();
    List<Question> generateMediumRandomMATHSQuestion();
    List<Question> generateHardRandomMATHSQuestion();
    List<Question> generateHISTORYQuestions();
    Question generateRandomHISTORYQuestion();
    List<Question> generateEasyRandomHISTORYQuestion();
    List<Question> generateMediumRandomHISTORYQuestion();
    List<Question> generateHardRandomHISTORYQuestion();
    List<Question> generateGEOGRAPHYQuestions();
    Question generateRandomGEOGRAPHYQuestion();
    List<Question> generateEasyRandomGEOGRAPHYQuestion();
    List<Question> generateMediumRandomGEOGRAPHYQuestion();
    List<Question> generateHardRandomGEOGRAPHYQuestion();
    List<Question> generateLITERATUREQuestions();

    Question generateRandomLITERATUREQuestion();
    List<Question> generateEasyRandomLITERATUREQuestion();
    List<Question> generateMediumRandomLITERATUREQuestion();
    List<Question> generateHardRandomLITERATUREQuestion();
    List<Question> generateSPORTQuestions();
    Question generateRandomSPORTQuestion();
    List<Question> generateEasyRandomSPORTQuestion();
    List<Question> generateMediumRandomSPORTQuestion();
    List<Question> generateHardRandomSPORTQuestion();
    Question deleteQuestion(int idQuestion);
}

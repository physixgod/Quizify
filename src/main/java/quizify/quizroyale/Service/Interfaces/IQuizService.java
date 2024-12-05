package quizify.quizroyale.Service.Interfaces;

import quizify.quizroyale.DAO.Entities.Question;
import quizify.quizroyale.DAO.Entities.Quiz;

import java.util.Set;

public interface IQuizService {
    Quiz addQuiz(Quiz quiz);
    Quiz addQuizByUser(Quiz quiz,Integer idUser);
    Quiz updateQuiz(Quiz quiz);
    void addQuestionToQuiz(int idQuiz,int idQuestion);
    void removeQuestionFromQuiz(int idQuiz,int idQuestion);
    void deleteQuiz(int idQuiz);
    Set<Quiz> showAllQuiz();
    Quiz findQuizByid(int id);
    Set<Question> showQuizQuestions(int id);
    Set<Question> showQuizNotAffectedQuestions(int id);

}

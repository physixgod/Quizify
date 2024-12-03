package quizify.quizroyale.Service.Interfaces;

import quizify.quizroyale.DAO.Entities.Quiz;

public interface IQuizService {
    Quiz addQuiz(Quiz quiz);
    Quiz updateQuiz(Quiz quiz);
    void addQuestionToQuiz(int idQuiz,int idQuestion);
    void removeQuestionFromQuiz(int idQuiz,int idQuestion);
    void deleteQuiz(int idQuiz);

}

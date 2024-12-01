package quizify.quizroyale.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import quizify.quizroyale.DAO.Enums.DifficultyLevel;
import quizify.quizroyale.DAO.Enums.QuestionCategory;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idQuestion;
    String questionText;
    String option1;
    String option2;
    String option3;
    String option4;
    String correctOption;
    @Enumerated(EnumType.STRING)
    DifficultyLevel difficultyLevel;
    @Enumerated(EnumType.STRING)
    QuestionCategory questionCategory;
    LocalDateTime createdDate;
    LocalDateTime updateDate;

}

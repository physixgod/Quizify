package quizify.quizroyale.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idQuizz;
    String quizTitle;
    float passingScore;
    int passingTIME;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Question> Questions;

}

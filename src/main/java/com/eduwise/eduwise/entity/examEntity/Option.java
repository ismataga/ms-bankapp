package com.eduwise.eduwise.entity.examEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "option")
public class Option {
    @Id
    private Long id;
    private String text;
    private boolean isCorrect;
//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Question question;
}

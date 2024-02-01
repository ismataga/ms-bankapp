package com.eduwise.eduwise.entity.examEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Duration;
import java.time.LocalDateTime;
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
@Table(name = "examsDetails")
public class ExamDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Duration duration;
    private String info;
    private LocalDateTime startTime;
    private LocalDateTime lastEnterTime;
    private boolean explainAnswersAfterward;
    private boolean acceptChecksLater;
    private int maxPurchases;
    private boolean isLive;
}

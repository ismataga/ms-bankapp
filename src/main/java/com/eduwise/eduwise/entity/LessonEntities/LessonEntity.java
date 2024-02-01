package com.eduwise.eduwise.entity.LessonEntities;

import com.eduwise.eduwise.configration.DurationDeserializer;
import com.eduwise.eduwise.configration.DurationSerializer;
import com.eduwise.eduwise.model.enums.LessonType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Duration;
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
@Table(name = "lesssons")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String videoUrl;
    private String lastPlaceStay;
    private String description;
    private Duration duration;
    private Boolean isCompleted;
    private LessonType lessonType;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity section;
}

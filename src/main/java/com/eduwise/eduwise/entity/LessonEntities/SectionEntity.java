package com.eduwise.eduwise.entity.LessonEntities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Duration;
import java.util.List;
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
@Table(name = "sectionCourse")
public class SectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectionId;
    private String name;
    private Long duration;
    private Integer articleCount;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<LessonEntity> lessons;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<ArticleEntity> articles;
}
package com.eduwise.eduwise.entity.LessonEntities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;
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
@Table(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean bestSeller;
    private boolean isBuyed;
    private String coverImageUrl;
    private Long duration;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;
    private Integer studentCount;
    private Integer quizCount;
    private Integer articleCount;
    private BigInteger monthlyPrice;
    private BigInteger quarterlyPrice;
    private BigInteger annuallyPrice;
    private BigInteger semiAnnuallyPrice;
    private BigInteger discount;
    @OneToMany(mappedBy = "courseId")
    private List<SectionEntity> sections;
    @OneToMany(mappedBy = "id")
    private List<RatingEntity> ratingEntities;
    @ManyToOne
    private InstructorEntity instructor;
}

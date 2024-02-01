package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.RATING_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.entity.LessonEntities.RatingEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.RatingMapper;
import com.eduwise.eduwise.model.adminDto.RatingStatistic;
import com.eduwise.eduwise.model.adminDto.requests.RatingRequest;
import com.eduwise.eduwise.repository.lessonRepository.RatingRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;
    public List<RatingEntity> getWaitingReviews(Long courseId) {
        return ratingRepository.findByCourseIdAndIsWaiting(courseId, true);
    }

    public void approveReview(Long reviewId) {
        RatingEntity review = ratingRepository.findById(reviewId)
                .orElseThrow(() -> new AppException(reviewId, RATING_NOT_FOUND));

        review.setWaiting(false);
        ratingRepository.save(review);
    }
    public RatingStatistic rate(Long userId, RatingRequest ratingRequest) {
        var rating = ratingMapper.toRatingEntity(userId, ratingRequest);

        ratingRepository.save(rating);
        RatingStatistic ratingStatistic = getRateStatistic(rating.getCourseId());
        return ratingStatistic;
    }

    private RatingStatistic getRateStatistic(Long courseId) {
//        return new RatingStatistic();
        return ratingRepository.getRatingStatistic(courseId)
                .orElseThrow(() -> new AppException(courseId, RATING_NOT_FOUND));
    }

}

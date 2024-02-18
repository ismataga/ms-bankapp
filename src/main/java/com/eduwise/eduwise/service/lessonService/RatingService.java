package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.RATING_NOT_FOUND;
import static com.eduwise.eduwise.model.enums.ExceptionConstants.USER_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.RatingEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.RatingMapper;
import com.eduwise.eduwise.model.adminDto.RatingStatistic;
import com.eduwise.eduwise.model.adminDto.requests.RatingRequest;
import com.eduwise.eduwise.repository.UserRepository;
import com.eduwise.eduwise.repository.lessonRepository.RatingRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final RatingMapper ratingMapper;


    public List<RatingEntity> getWaitingReviews(Long courseId) {
        return ratingRepository.findByCourseIdAndIsWaiting(courseId, false);
    }

    public void approveReview(Long reviewId) {
        RatingEntity review = ratingRepository.findById(reviewId)
                .orElseThrow(() -> new AppException(reviewId, RATING_NOT_FOUND));

        review.setWaiting(true);
        ratingRepository.save(review);
    }

    public RatingStatistic rate(Long userId, RatingRequest ratingRequest) {
        userRepository.findById(userId)
                .orElseThrow(() -> new AppException(userId, USER_NOT_FOUND));

        var rating = ratingMapper.toRatingEntity(userId, ratingRequest);

        ratingRepository.save(rating);
        return getRateStatistic(rating.getCourseId());
    }

    private RatingStatistic getRateStatistic(Long courseId) {
//        return new RatingStatistic();
        return ratingRepository.getRatingStatistic(courseId)
                .orElseThrow(() -> new AppException(courseId, RATING_NOT_FOUND));
    }


}

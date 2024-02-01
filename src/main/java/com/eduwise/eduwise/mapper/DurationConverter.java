package com.eduwise.eduwise.mapper;

import java.time.Duration;
import java.util.Optional;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class DurationConverter {
    @Named("toMinutes")
    public static Long toMinutes(Duration duration) {
        return Optional.ofNullable(duration).map(Duration::toMinutes).orElse(null);
    }

    @Named("fromMinutes")
    public static Duration fromMinutes(Long durationMinutes) {
        return Optional.ofNullable(durationMinutes).map(Duration::ofMinutes).orElse(null);
    }


}

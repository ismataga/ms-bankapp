package com.eduwise.eduwise.mapper.admin;

import com.eduwise.eduwise.entity.LessonEntities.CourseEntity;
import com.eduwise.eduwise.model.adminDto.requests.CourseRequest;
import com.eduwise.eduwise.model.adminDto.responses.CourseResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    //    @Mapping(target = "createdAt",ignore = true)
//    @Mapping(target = "updateAt",ignore = true)
    CourseEntity mapToEntity(CourseRequest courseRequest);

    //    @Mapping(source = "sections", target = "sections", ignore = true)
//    @Mapping(target = "createdAt",source = "createdAt")
//    @Mapping(target = "updateAt",source = "createdAt")
    CourseResponse entityToCourseResponse(CourseEntity courseEntity);

    List<CourseResponse> entityToCourseResponseList(List<CourseEntity> courseEntities);

}

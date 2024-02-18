package com.eduwise.eduwise.service.lessonService;

import static com.eduwise.eduwise.model.enums.ExceptionConstants.INSTRUCTOR_NOT_FOUND;

import com.eduwise.eduwise.entity.LessonEntities.InstructorEntity;
import com.eduwise.eduwise.exception.AppException;
import com.eduwise.eduwise.mapper.admin.InstructorMapper;
import com.eduwise.eduwise.model.adminDto.requests.InstructorRequest;
import com.eduwise.eduwise.model.adminDto.responses.InstructorResponse;
import com.eduwise.eduwise.repository.lessonRepository.InstructorRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public void addInstructor(InstructorRequest instructorRequest) {
        InstructorEntity instructorEntity = instructorMapper.toEntity(instructorRequest);
        instructorRepository.save(instructorEntity);
    }

    public InstructorResponse getInstructorById(Long id) {
        InstructorEntity instructorEntity = instructorRepository.findById(id)
                .orElseThrow(() -> new AppException(id, INSTRUCTOR_NOT_FOUND));
        return instructorMapper.toInstructorResponse(instructorEntity);

    }

    public List<InstructorResponse> getAllInstructors() {
        List<InstructorEntity> instructorEntity = instructorRepository.findAll();
        return instructorMapper.toInstructorResponseList(instructorEntity);
    }

    public void updateInstructorById(Long id, InstructorRequest instructorRequest) {
        InstructorEntity instructorEntity = instructorRepository.findById(id)
                .orElseThrow(() -> new AppException(id, INSTRUCTOR_NOT_FOUND));
    }

    public void deleteInstructorById(Long id) {
        InstructorEntity instructorEntity = instructorRepository.findById(id)
                .orElseThrow(() -> new AppException(id, INSTRUCTOR_NOT_FOUND));
        instructorRepository.delete(instructorEntity);
    }
}

package com.eduwise.eduwise.model.adminDto.requests;

import com.eduwise.eduwise.entity.User;

public record InstructorRequest(Long id,User userId,String photoUrl) {
}

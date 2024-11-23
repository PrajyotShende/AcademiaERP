package prajyot.academiaerp.Mapper;

import prajyot.academiaerp.Dto.StudentLoginRequest;
import prajyot.academiaerp.Dto.StudentLoginResponse;
import prajyot.academiaerp.Entity.Student;
import org.springframework.stereotype.Service;



@Service
public class StudentLoginMapper {

    public Student toEntity(StudentLoginRequest request) {
        return Student.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }



    public StudentLoginResponse toResponse(Student student) {
        return new StudentLoginResponse(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
//                jwtToken
        );
    }
}

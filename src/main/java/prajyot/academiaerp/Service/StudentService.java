package prajyot.academiaerp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prajyot.academiaerp.Entity.Student;
import prajyot.academiaerp.Util.JWTUtil;
import prajyot.academiaerp.Util.SHA256Util;
import prajyot.academiaerp.Dto.StudentLoginResponse;
import prajyot.academiaerp.Dto.StudentLoginRequest;
import prajyot.academiaerp.Mapper.StudentLoginMapper;
import prajyot.academiaerp.Repository.Student_Repository;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private Student_Repository student_Repository;

    @Autowired
    private StudentLoginMapper studentLoginMapper;

    public String login(StudentLoginRequest loginRequest) {
        Optional<Student> opt = student_Repository.findByEmail(loginRequest.email());
        if (opt.isEmpty()) {
            throw new RuntimeException("Student not found");
        }

        Student student = opt.get();
        String hashPassword = SHA256Util.hashPassword(loginRequest.password());

        if (!hashPassword.equals(student.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String JwtToken = JWTUtil.generateToken(student.getEmail());
//        System.out.println("Generated JWT Token: " + JwtToken );
            return JwtToken;
//        return studentLoginMapper.toResponse(student);
    }
}

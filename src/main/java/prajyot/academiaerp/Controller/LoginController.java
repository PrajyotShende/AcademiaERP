package prajyot.academiaerp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import prajyot.academiaerp.Dto.StudentLoginRequest;
import prajyot.academiaerp.Dto.StudentLoginResponse;
import prajyot.academiaerp.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<StudentLoginResponse> login(@Valid @RequestBody StudentLoginRequest loginRequest) {
        try {
            StudentLoginResponse loginResponse = studentService.login(loginRequest);
            return ResponseEntity.ok(loginResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(null);
        }
    }
}

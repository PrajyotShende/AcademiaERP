package prajyot.academiaerp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import prajyot.academiaerp.Service.BillingService;
import prajyot.academiaerp.Dto.DueBillDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class DueBillsController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/{studentId}/due-bills")
    public List<DueBillDTO> getDueBillsForStudent(@PathVariable int studentId) {
        return billingService.getDueBillsForStudent(studentId);
    }
}

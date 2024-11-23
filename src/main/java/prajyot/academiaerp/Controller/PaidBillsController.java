package prajyot.academiaerp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import prajyot.academiaerp.Service.BillingService;
import prajyot.academiaerp.Dto.PaidBillDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class PaidBillsController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/{studentId}/paid-bills")
    public List<PaidBillDTO> getPaidBillsForStudent(@PathVariable int studentId) {
        return billingService.getPaidBillsForStudent(studentId);
    }
}

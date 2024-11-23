//package prajyot.academiaerp.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import prajyot.academiaerp.Service.BillingService;
//import prajyot.academiaerp.Dto.BillStatusDTO;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/student")
//public class StudentBillingController {
//
//    @Autowired
//    private BillingService billingService;
//
//    @GetMapping("/{studentId}/bills")
//    public List<List<BillStatusDTO>> getBillsForStudent(@PathVariable int studentId) {
//        return billingService.getBillsForStudent(studentId);
//    }
//}

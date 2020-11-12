package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.demo.domain.Student;
import springboot.demo.repository.StudentRepository;

import java.util.List;

@Controller
public class QueryController {
    @Autowired
    StudentRepository studentRepository;
    /**
     * 模糊查询
     * @param
     * @param model
     * @return
     */
    @GetMapping("/query")
    private String query(@RequestParam("student") String student, Model model){

        List<Student> stu = studentRepository.getquer(student);
        model.addAttribute("student",stu);
        return "queryList";
    }
}

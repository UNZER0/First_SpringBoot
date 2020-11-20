package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.domain.Student;
import springboot.demo.repository.StudentRepository;

import java.util.List;

@RestController
public class RepeatController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/studentidrepeat")
    public Integer studentIdRepeat(@RequestParam("studentid") String studentid, Model model){
        System.out.println(studentid);
        List<Student> students = studentRepository.findByStudentid(studentid);
        System.out.println(students);
        if (students.size()>0){
            return 1;  //重复
        }else {
            return 0;  //不重复
        }
    }
}

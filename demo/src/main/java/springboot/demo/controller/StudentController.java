package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.demo.domain.Student;
import springboot.demo.repository.StudentRepository;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //跳转到添加增加学生
    @GetMapping("/addstudent")
    private String addstudent(){
        return "addstudent";
    }

    /**
     * 增加学生信息
     * @param
     * @return
     */
    @PostMapping("/haddleaddstudent")
    private String haddleaddstudent(Student student){
        studentRepository.save(student);
        return "redirect:/?page=999&message=3";
    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    private String deleteById(@PathVariable("id") Integer id,@RequestParam(defaultValue = "1") int page){
        studentRepository.deleteById(id);
        return "redirect:/?page="+page+"&message=2";
    }

    /**
     * 跳转修改页面
     * @param id
     * @return
     */
    @GetMapping("/modify/{id}")
    private String modifyById(@PathVariable("id") Integer id,Model model,@RequestParam(defaultValue = "1") int page){
        Optional<Student> optional = studentRepository.findById(id);
        Student student = optional.get();
        model.addAttribute("student",student);
        model.addAttribute("page",page);
        return "modifystudent";
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @PostMapping("/modifystudent")
    private String modifyStudent(Student student,@RequestParam(defaultValue = "1") int page){
        studentRepository.save(student);
        return "redirect:/?page="+page+"&message=1";
    }
}
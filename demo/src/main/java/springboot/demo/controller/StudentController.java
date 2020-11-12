package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.demo.domain.Page;
import springboot.demo.domain.Student;
import springboot.demo.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 系统主界面
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model ){
        int page=1;
        //每页显示多少条数据
        int num=8;
        //总共多少数据
        int sum = (int)studentRepository.count();
        //算出总页数
        int total=sum/num+1;
        //判断数据是否合法，每页最多显示8条数据
        if (sum<8){
            num=sum;
        }
        //计算从第几条数据查找
        int p=(page-1)*num;
        //传入当前页和每页显示多少条数据
        List<Student> students = studentRepository.getList(p,  num);
        //前端显示页数
        Page page1 = new Page();
        page1.setPagination(total,page);
        //加入属性
        model.addAttribute("student",students);
        model.addAttribute("num",num);
        model.addAttribute("page",page1);
        return "index";
    }
    /**
     * 分页
     * @param
     * @return
     */

    @GetMapping("/page/{p}")
    public String page(Model model,@PathVariable("p") int page){
        //每页显示多少条数据
        int num=8;
        //总共多少数据
        int sum = (int)studentRepository.count();
        //算出总页数
        int total=(sum-1)/num+1;
        //判断数据是否合法，每页最多显示8条数据
        if (sum<8){
            num=sum;
        }
        //如果当前页小于1
        if (page<1){
            page=1;
        }
        //如果当前页大于最大页数
        if (page>total){
            page=total;
        }
        //计算从第几条数据查找
        int p=(page-1)*num;
        //传入当前页和每页显示多少条数据
        List<Student> students = studentRepository.getList(p,  num);

        //分页查找

        //前端显示页数
        Page page1 = new Page();
        page1.setPagination(total,page);
        //加入属性
        model.addAttribute("student",students);
        model.addAttribute("num",num);
        model.addAttribute("page",page1);
        return "index";
    }
    /**
     * 查看所有学生信息
     * @param model
     * @return
     */
    @GetMapping("/findallstudent")
    private String studentAllList(Model model){
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("student",studentList);
        return "studentlist";
    }
    /**
     * 跳转到添加增加学生
     * @param model
     * @return
     */
    @GetMapping("/addstudent")
    private String addstudent(Model model){

        return "addstudent";
    }

    /**
     * 增加学生信息
     * @param
     * @return
     */
    @PostMapping("/haddleaddstudent")
    private String haddleaddstudent(    @RequestParam("name") String name,
                                        @RequestParam("gender")  String gender,
                                        @RequestParam("student_id")  String student_id,
                                        @RequestParam("department") String department,
                                        @RequestParam("grade") String grade,
                                        @RequestParam("level") String level,
                                        @RequestParam("account") String account,
                                        @RequestParam("password") String password){
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setStudent_id(student_id);
        student.setDepartment(department);
        student.setGrade(grade);
        student.setLevel(level);
        student.setAccount(account);
        student.setPassword(password);
        studentRepository.save(student);
        return "redirect:/";
    }


    /**
     * 删除学生
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    private String deleteById(@PathVariable("id") Integer id){
        studentRepository.deleteById(id);
        return "redirect:/";
    }

    /**
     * 跳转修改页面
     * @param id
     * @return
     */
    @GetMapping("/modify/{id}")
    private String modifyById(@PathVariable("id") Integer id,Model model){
        Optional<Student> optional = studentRepository.findById(id);
        Student student = optional.get();
        model.addAttribute("student",student);
        return "modifystudent";
    }



    /**
     * 修改学生信息
     * @param name
     * @param gender
     * @param student_id
     * @param department
     * @param grade
     * @param level
     * @param account
     * @param password
     * @return
     */
    @PostMapping("/modfifystudent")
    private String modifyStudent( @RequestParam("id") Integer id,
                                  @RequestParam("name") String name,
                                  @RequestParam("gender")  String gender,
                                  @RequestParam("student_id")  String student_id,
                                  @RequestParam("department") String department,
                                  @RequestParam("grade") String grade,
                                  @RequestParam("level") String level,
                                  @RequestParam("account") String account,
                                  @RequestParam("password") String password){
        Optional<Student> optional = studentRepository.findById(id);
        Student student = optional.get();
        student.setName(name);
        student.setGender(gender);
        student.setStudent_id(student_id);
        student.setDepartment(department);
        student.setGrade(grade);
        student.setLevel(level);
        student.setAccount(account);
        student.setPassword(password);
        studentRepository.save(student);
        return "redirect:/";
    }
}

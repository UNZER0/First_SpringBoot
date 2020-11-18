package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.demo.domain.Student;
import springboot.demo.dto.Page;
import springboot.demo.repository.StudentRepository;
import springboot.demo.service.Paging;

import java.util.List;

@Controller
public class IndexDisplayController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Paging paging;
    //每页显示多少条数据
    final int num = 8;

    /**
     * 系统主界面
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model,@RequestParam(defaultValue = "1")int page,@RequestParam(value = "message",required = false) String message){
        //获取每页展示的对象
        List<Student> students = paging.getlist(page);
        //前端显示页数
        Page page1 = paging.getPage(page);
        //加入属性
        System.out.println(message);
        model.addAttribute("message",message);
        model.addAttribute("student",students);
        model.addAttribute("num",num);
        model.addAttribute("page",page1);
        return "index";
    }

    /**
     * 模糊查询
     * @param
     * @param model
     * @return
     */
    @GetMapping("/query")
    private String query(@RequestParam("name") String name, Model model){
        //获取模糊查询学生列表
        List<Student> students = studentRepository.getquerList(name);
        //加入属性
        model.addAttribute("student",students);
        return "queryList";
    }
}

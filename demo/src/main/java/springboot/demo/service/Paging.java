package springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.demo.domain.Student;
import springboot.demo.repository.StudentRepository;

import java.util.List;

@Component
public class Paging {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getlist(int page,int sum){

        int total=0;
        //判断数据是否合法，每页最多显示9条数据
        if (sum>9){
            total=9;
        }else {
            total=sum;
        }
        //如果当前页小于1
        if (page<1){
            page=0;
        }else {
            page--;
        }
        //如果当前页大于最大页数
        if (page>sum/total+1){
            page=sum/total;
        }else {
            page--;
        }
        //传入当前页和每页显示多少条数据
        List<Student> list = studentRepository.getList(page,  total);
        System.out.println(list);
        return list;
    }

}

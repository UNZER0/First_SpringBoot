package springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.dto.Page;
import springboot.demo.domain.Student;
import springboot.demo.repository.StudentRepository;

import java.util.List;

@Service
public class Paging {
    @Autowired
    private StudentRepository studentRepository;

    //每页显示多少条数据
    final int num = 8;

    //获取页码
    public Page getPage(int page) {
        //总共多少数据
        int sum = (int) studentRepository.count();
        //算出总页数
        int total = (sum - 1) / num + 1;
        //使当前页合法
        page = legitimatePage(page, sum);
        Page p = new Page();
        p.setPagination(total, page);
        return p;
    }

    //获取每页展示的学生列表
    public List<Student> getlist(int page) {
        //总共多少数据
        int sum = (int) studentRepository.count();
        //当数据库中的总记录条数小于当前要展示的记录，更新n
        int n=num;
        if (sum < n) {
            n = sum;
        }
        if(n==0){
            n=1;
        }
        //使当前页合法
        page = legitimatePage(page, sum);
        //计算从第几条数据查找
        int p = (page - 1) * n;
        //传入当前页和每页显示多少条数据
        List<Student> students = studentRepository.getList(p, n);
        return students;
    }

    //使前端传过来的当前页合法！
    public int legitimatePage(int page, int sum) {
        //算出总页数
        int total = (sum - 1) / num + 1;
        //如果当前页小于1
        if (page < 1) {
            page = 1;
        }
        //如果当前页大于最大页数
        if (page > total) {
            page = total;
        }
        return page;
    }
}

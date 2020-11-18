package springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springboot.demo.domain.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    //分页查询
    @Query(value = "select * from Student limit :page,:total",nativeQuery = true)
    List<Student> getList(@Param("page") int page,@Param("total") int total);

    //模糊查询
    @Query(value = "select * from Student where name like CONCAT('%',:name,'%') ",nativeQuery = true)
    List<Student> getquerList(@Param("name") String name);
}

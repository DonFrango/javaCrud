package teacherWebApp.teacherapp.repository;

import teacherWebApp.teacherapp.model.Student;
import org.springframework.data.repository.CrudRepository;
public interface StudentRep extends CrudRepository<Student, Integer> {
    public Long countById(Integer id);
}

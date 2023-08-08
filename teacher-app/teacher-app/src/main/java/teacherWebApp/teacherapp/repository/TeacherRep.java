package teacherWebApp.teacherapp.repository;

import teacherWebApp.teacherapp.model.Teacher;
import org.springframework.data.repository.CrudRepository;
    public interface TeacherRep extends CrudRepository<Teacher, Integer> {
        public Long countById(Integer id);
    }

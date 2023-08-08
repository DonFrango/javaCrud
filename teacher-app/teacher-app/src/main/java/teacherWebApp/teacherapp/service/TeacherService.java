package teacherWebApp.teacherapp.service;

import teacherWebApp.teacherapp.exception.TeacherException;
import teacherWebApp.teacherapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teacherWebApp.teacherapp.repository.TeacherRep;

import java.util.List;
import java.util.Optional;

    @Service
    public class TeacherService {
        @Autowired private TeacherRep repo;

        public List<Teacher> listAll() {
            return (List<Teacher>) repo.findAll();
        }

        public void save(Teacher teacher) {
            repo.save(teacher);
        }

        public Teacher get(Integer id) throws TeacherException {
            Optional<Teacher> result = repo.findById(id);
            if (result.isPresent()) {
                return result.get();
            }
            throw new TeacherException("Could not find any teacher with ID " + id);
        }

        public void delete(Integer id) throws TeacherException {
            Long count = repo.countById(id);
            if (count == null || count == 0) {
                throw new TeacherException("Could not find any teacher with ID " + id);
            }
            repo.deleteById(id);
        }
    }


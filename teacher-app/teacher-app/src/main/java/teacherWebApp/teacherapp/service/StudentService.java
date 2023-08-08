package teacherWebApp.teacherapp.service;


import teacherWebApp.teacherapp.exception.StudentException;
import teacherWebApp.teacherapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teacherWebApp.teacherapp.repository.StudentRep;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired private StudentRep repo;

    public List<Student> listAll() {
        return (List<Student>) repo.findAll();
    }

    public void save(Student student) {
        repo.save(student);
    }

    public Student get(Integer id) throws StudentException {
        Optional<Student> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new StudentException("Could not find any student with ID " + id);
    }

    public void delete(Integer id) throws StudentException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new StudentException("Could not find any student with ID " + id);
        }
        repo.deleteById(id);
    }

}
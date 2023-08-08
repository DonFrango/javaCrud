package teacherWebApp.teacherapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


    @Entity
    @Table(name = "teachers")
    public class Teacher {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false, length = 45, name = "email")
        private String email;

        @Column(length = 15, nullable = false, name = "password")
        private String password;

        @Column(length = 45, nullable = false, name = "first_name")
        private String firstName;

        @Column(length = 45, nullable = false, name = "last_name")
        private String lastName;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
        private List<Student> students = new ArrayList<>();

        @Column(length = 45, nullable = false, name = "enabled")
        private boolean enabled;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "id=" +
                    ", email='"+
                    ", password='"+
                    ", firstName='" +
                    ", lastName='" +
                    ", students="  +
                    ", enabled=" +
                    '}';
        }
    }


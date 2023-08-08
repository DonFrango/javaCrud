package teacherWebApp.teacherapp.model;

import javax.persistence.*;

    @Entity

    @Table(name = "students")
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false, length = 45, name = "email")
        private String email;

        @Column(length = 15, nullable = false, name = "password")
        private String password;

        @Column(length = 45, nullable = false, name = "first_name")
        private String sName;

        @Column(length = 45, nullable = false, name = "last_name")
        private String sLastName;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "teacher_id", nullable = false)
        private Teacher teacher;

        @Column(length = 45, nullable = false, name = "enabled")
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

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

        public String getsName() {
            return sName;
        }

        public void setsName(String sName) {
            this.sName = sName;
        }

        public String getsLastName() {
            return sLastName;
        }

        public void setsLastName(String sLastName) {
            this.sLastName = sLastName;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", sName='" + sName + '\'' +
                    ", sLastName='" + sLastName + '\'' +
                    ", teacher=" + teacher +
                    ", enabled=" + enabled +
                    '}';
        }
    }

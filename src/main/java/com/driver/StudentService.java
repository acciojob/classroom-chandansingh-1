package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    public void addStudentService(Student student) {
        studentRepo.addStudentToDB(student);
    }

    public void addTeacherService(Teacher teacher) {
        studentRepo.addTeacherToDB(teacher);
    }

    public void addStudentTeacher(String studentName, String teacherName) {
        studentRepo.addStudentTeacherTogether(studentName, teacherName);
    }

    public Student getStudent(String studentName) {
        return studentRepo.getStudentFromDB(studentName);
    }

    public Teacher getTeacher(String teacherName) {
        return studentRepo.getTeacherFromDB(teacherName);
    }

    public List<String> getStudentsByTeacher(String teacher) {
        return studentRepo.getListOfStudents(teacher);
    }

    public List<String> getAllStudentsFromRecords() {
        return studentRepo.GetAllStudentsFromDB();
    }

    public void deleteTeacherAndTheirStudents(String teacherName) {
        studentRepo.deleteTeacherAndTheirStudents(teacherName);
    }

    public void deleteAllTeachersAndTheirStudents() {
        studentRepo.deleteAllTeachersAndTheirStudents();
    }
}

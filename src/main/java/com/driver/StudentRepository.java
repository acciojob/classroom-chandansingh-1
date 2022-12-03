package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<String, Student> students = new HashMap<>();
    Map<String, Teacher> teachers = new HashMap<>();
    Map<String, List<String>> teaches = new HashMap<>();

    public void addStudentToDB(Student student) {
        students.put(student.getName(), student);
    }

    public void addTeacherToDB(Teacher teacher) {
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherTogether(String studentName, String teacherName) {
        if(teachers.containsKey(teacherName)) {
            if(!teaches.containsKey(teacherName)) {
                teaches.put(teacherName, new ArrayList<>());
            }
            if(students.containsKey(studentName)) {
                teaches.get(teacherName).add(studentName);
            }
        }
    }

    public Student getStudentFromDB(String studentName) {
        if(students.containsKey(studentName))
            return students.get(studentName);

        return null;
    }

    public Teacher getTeacherFromDB(String teacherName) {
        if(teachers.containsKey(teacherName))
            return teachers.get(teacherName);

        return null;
    }

    public List<String> getListOfStudents(String teacherName) {
        if(teaches.containsKey(teacherName))
            return teaches.get(teacherName);

        return null;
    }

    public List<String> GetAllStudentsFromDB() {
        List<String> listOfStudents = new ArrayList<>();
        for(String studentName : students.keySet())
            listOfStudents.add(studentName);

        return listOfStudents;
    }

    public void deleteTeacherAndTheirStudents(String teacherName) {
        if(teachers.containsKey(teacherName)) {
            if(teaches.containsKey(teacherName)) {
                for(String studentName : teaches.get(teacherName)){
                    students.remove(studentName);
                }
                teaches.remove(teacherName);
            }
            teachers.remove(teacherName);
        }
    }

    public void deleteAllTeachersAndTheirStudents() {
        for(String teacherName : teachers.keySet()) {
            if(teaches.containsKey(teacherName)) {
                for(String studentName : teaches.get(teacherName)) {
                    students.remove(studentName);
                }
                teaches.remove(teacherName);
            }
            teachers.remove(teacherName);
        }
    }
}

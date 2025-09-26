package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.IStudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(IStudentDAO studentDAO){
        return runner -> {
            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//              queryForStudents(studentDAO);
//              queryForStudentsByLastName(studentDAO);
//              updateStudent(studentDAO);
//                deleteStudent(studentDAO);
//                deleteAll(studentDAO);

        };

    }

    public void deleteAll(IStudentDAO studentDAO){
        int rowsDeleted = studentDAO.deleteAll();
        System.out.println("Rows Deleted: " + rowsDeleted);
    }

    public void deleteStudent(IStudentDAO studentDAO){
        int studentId = 3;
        System.out.println("Deleting student with id");
        studentDAO.delete(studentId);
    }

    public void updateStudent(IStudentDAO studentDAO){
        int studentId = 1;
        Student student = studentDAO.findById(studentId);
        student.setFirstName("Scooby");
        studentDAO.update(student);
        System.out.println(student);
    }


    private void queryForStudentsByLastName(IStudentDAO studentDAO){
        List<Student> students = studentDAO.findByLastName("Duck");
        for (Student student: students){
            System.out.println(student);
        }
    }

    private void queryForStudents(IStudentDAO studentDAO){

        List<Student> students = studentDAO.findAll();

        for (Student student: students){
            System.out.println(student);
        }

    }

    private void readStudent(IStudentDAO studentDAO){
        System.out.println("Creating a new student object");
        Student tempStudent = new Student("Daffy", "Duck", "paul@luv2code.com");
        System.out.println("Saving the student");
        studentDAO.save(tempStudent);
        System.out.println("Display student id");
        int id = tempStudent.getId();
        System.out.println("Find student with id");
        Student myStudent = studentDAO.findById(id);
        System.out.println("Found the student: " + myStudent);

    }

    private void createStudent(IStudentDAO studentDAO){
        System.out.print("Creating a new student object");
        Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

        System.out.print("Saving the student");
        studentDAO.save(tempStudent);

        System.out.print("Saved student. Generated id: " + tempStudent.getId());
    }

    private void createMultipleStudents(IStudentDAO studentDAO){
        System.out.print("Creating 3 new student object");
        Student tempStudent1 = new Student("John", "Doe", "paul@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "paul@luv2code.com");
        Student tempStudent3 = new Student("Bonita", "Applebaum", "paul@luv2code.com");

        System.out.print("Saving the students");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

}

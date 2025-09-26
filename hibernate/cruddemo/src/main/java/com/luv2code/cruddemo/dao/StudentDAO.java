package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO {


    private EntityManager entityManager;

    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }


    @Override
    @Transactional
    public void update(Student student){
        this.entityManager.merge(student);
    }

    @Override
    public Student findById(Integer id){
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery =  this.entityManager.createQuery("FROM Student order by lastName", Student.class);
        // return the results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> theQuery =  this.entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id){
        // retrieve the student
        Student student = entityManager.find(Student.class, id);
        // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return this.entityManager.createQuery("DELETE FROM Student").executeUpdate();

    }
}

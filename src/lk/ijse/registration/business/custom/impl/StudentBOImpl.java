/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.business.custom.impl;

import lk.ijse.registration.business.custom.StudentBO;
import lk.ijse.registration.dao.custom.StudentDAO;
import lk.ijse.registration.dto.StudentDTO;
import lk.ijse.registration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SSNLIVE
 */
@Component
@Transactional
public class StudentBOImpl implements StudentBO{

    @Autowired
    private StudentDAO studentDAO;

    public StudentBOImpl(){


    }
    

    
    public boolean addStudent(StudentDTO student)throws Exception{

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//
//         studentDAO.setEntityManager(entityManager);


         Student student1 = new Student(student.getStID(),student.getName(),student.getAddress());
         studentDAO.save(student1);
//         entityManager.getTransaction().commit();
//         entityManager.close();

         return true;




    }
    
    public ArrayList<StudentDTO> getAllStudents ()throws Exception{
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//
//       studentDAO.setEntityManager(entityManager);

       List<Student> allstudents = studentDAO.getAll();



       ArrayList<StudentDTO> dtos = new ArrayList<>();

       for (Student student: allstudents){
           StudentDTO studentDTOs = new StudentDTO(student.getStID(),student.getName(),student.getAddress());
           dtos.add(studentDTOs);

       }
//        entityManager.getTransaction().commit();
//       entityManager.close();

       return dtos;


   }
        

    
    public boolean deleteStudent(String id)throws Exception{

//EntityManager entityManager = entityManagerFactory.createEntityManager();
//entityManager.getTransaction().begin();
//
//
//          studentDAO.setEntityManager(entityManager);


          studentDAO.delete(id);
//          entityManager.getTransaction().commit();
//          entityManager.close();

          return true;

    }
    
    public boolean updateStudent(StudentDTO student)throws Exception{

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//
//            studentDAO.setEntityManager(entityManager);


            Student student1 = studentDAO.find(student.getStID());
            student1.setName(student.getName());
            student1.setAddress(student.getAddress());
            studentDAO.update(student1);
//            entityManager.getTransaction().commit();
//            entityManager.close();

            return true;






    }
    
    public StudentDTO findStudent(String id)throws Exception{

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//
//
//    studentDAO.setEntityManager(entityManager);
    Student student = studentDAO.find(id);
    StudentDTO studentDTO = new StudentDTO(student.getStID(),student.getName(),student.getAddress());

//    entityManager.getTransaction().commit();
//    entityManager.close();

    return studentDTO;


}


    }
    


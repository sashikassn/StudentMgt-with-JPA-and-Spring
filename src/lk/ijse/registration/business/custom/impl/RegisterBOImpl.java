/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.registration.business.custom.RegisterBO;
import lk.ijse.registration.dao.custom.RegisterDAO;
import lk.ijse.registration.dto.RegisterDTO;
import lk.ijse.registration.entity.Register;
import lk.ijse.registration.entity.Register_PK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author SSNLIVE
 */
@Component
@Transactional
public class RegisterBOImpl implements RegisterBO {
    @Autowired
    private RegisterDAO registerDAO;



    public RegisterBOImpl(){

    }


    public boolean registerStudent(RegisterDTO register) throws Exception {
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//

//           registerDAO.setEntityManager(entityManager);



           Register register1 = new Register(register.getStID(),register.getcID(),register.getRegDate(),register.getFee());
           registerDAO.save(register1);

//           entityManager.getTransaction().commit();
//           entityManager.close();
           return true;
       }



    @Override
    public boolean updateregistration(RegisterDTO register) throws Exception {
//       EntityManager entityManager = entityManagerFactory.createEntityManager();
//       entityManager.getTransaction().begin();




//            registerDAO.setEntityManager(entityManager);

            Register_PK register_pk = new Register_PK(register.getStID(),register.getcID());
            Register register1 = registerDAO.find(register_pk);
            register1.setCourse(register1.getCourse());
            register1.setRegDate(register1.getRegDate());
            register1.setFee(register1.getFee());
//        entityManager.getTransaction().commit();
//        entityManager.close();
            return true;



        }



    public boolean deleteregistration(String stID, String cID) throws Exception {


//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//          registerDAO.setEntityManager(entityManager);

          Register_PK register_pk = new Register_PK(stID,cID);
          registerDAO.delete(register_pk);
//        entityManager.getTransaction().commit();
//        entityManager.close();
          return true;

      }


    public RegisterDTO findById(String stID, String cID) throws Exception {

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//            registerDAO.setEntityManager(entityManager);
            Register_PK register_pk = new Register_PK(stID,cID);
            Register register = registerDAO.find(register_pk);
            RegisterDTO registerDTO = new RegisterDTO(register.getRegister_PK().getStID(),register.getRegister_PK().getcID(),register.getRegDate(),register.getFee());
//        entityManager.getTransaction().commit();
//        entityManager.close();

            return registerDTO;


        }



    @Override
    public ArrayList<RegisterDTO> getAll() throws Exception {

//EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//entityManager.getTransaction().begin();
//
//
//            registerDAO.setEntityManager(entityManager);

            List<Register> allregs = registerDAO.getAll();
//            entityManager.getTransaction().commit();


           ArrayList<RegisterDTO> dtos = new ArrayList<>();


           for (Register register: allregs){
               RegisterDTO registerDTO = new RegisterDTO(register.getRegister_PK().getStID(),register.getRegister_PK().getcID(),register.getRegDate(),register.getFee());
               dtos.add(registerDTO);

           }
//        entityManager.getTransaction().commit();
//        entityManager.close();
                return dtos;


        

    }
    
     
    
}

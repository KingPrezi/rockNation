/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NetFlorist.repositories;

import com.NetFlorist.model.Users;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 *
 * @author User
 */
//provide custom controllers that take advantage of spring data rest functionality
@RepositoryRestController
public interface UsersRepository extends CrudRepository<Users, Integer> {
    
    //==============================Login Based on email And password=============================================
    @Query("SELECT u FROM Users u WHERE u.email = :email")
    public Users login(@Param("email") String email);
     
   
    
}

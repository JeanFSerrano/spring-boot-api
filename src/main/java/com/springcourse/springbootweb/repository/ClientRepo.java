package com.springcourse.springbootweb.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcourse.springbootweb.model.ClientModel;



public interface ClientRepo extends JpaRepository<ClientModel, UUID>  {
    
}

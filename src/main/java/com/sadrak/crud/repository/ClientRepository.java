package com.sadrak.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sadrak.crud.model.Client;

@Repository //Define a classe como um bean do Spring
public interface ClientRepository extends JpaRepository<Client, Long> { }
//Deve estender JpaRepository e declarar a entidade (Post) e o tipo de chave primária (Long)


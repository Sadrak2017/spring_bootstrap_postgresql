package com.sadrak.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sadrak.crud.model.Client;
import com.sadrak.crud.repository.ClientRepository;
import java.util.List;

@Service //Define a classe como um bean do Spring
public class ClientService {
  @Autowired
  private ClientRepository repository; //Injeta o repositório

  //Retorna uma lista com todos posts inseridos
  public List<Client> findAll() {
    return repository.findAll();
  }

  //Retorno um post a partir do ID
  public Client findOne(Long id) {
    return repository.getOne(id);
  }

  //Salva ou atualiza um post
  public Client save(Client client) {
    return repository.saveAndFlush(client);
  }

  //Exclui um post
  public void delete(Long id) {
    repository.deleteById(id);
  }
}

package com.sadrak.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sadrak.crud.model.Client;
import com.sadrak.crud.service.ClientService;
import javax.validation.Valid;

@Controller //Define a classe como um bean do Spring
public class ClientController {
  @Autowired
  private ClientService service; //	Injeta a classe de serviços

  //Vai para tela principal do CRUD aonde são listados todos os posts
  @GetMapping("/")
  public ModelAndView findAll() {
    ModelAndView mv = new ModelAndView("/client");
    mv.addObject("clientes", service.findAll());
    System.out.println(service.findAll().get(0).getName());
    return mv;
  }

  //Vai para tela de adição de post
  @GetMapping("/insert")
  public ModelAndView add(Client client) {
    ModelAndView mv = new ModelAndView("/newClient");
    mv.addObject("cliente", client);
    return mv;
  }

  //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
  @GetMapping("/update/{id}")
  public ModelAndView edit(@PathVariable("id") Long id) {
    return add(service.findOne(id));
  }

  //Exclui um post por seu ID e redireciona para a tela principal
  @GetMapping("/delete/{id}")
  public ModelAndView delete(@PathVariable("id") Long id) {
    service.delete(id);
    return findAll();
  }

  //Recebe um objeto preenchido do Thymeleaf e valida
  //Se tudo estiver ok, salva e volta para tela principal
  //Se houver erro, retorna para tela atual exibindo as mensagens de erro
  @PostMapping("/save")
  public ModelAndView save(@Valid Client client, BindingResult result) {

    if(result.hasErrors()) {
      return add(client);
    }

    service.save(client);
    return findAll();
  }
}

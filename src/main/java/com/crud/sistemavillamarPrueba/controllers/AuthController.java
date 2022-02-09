package com.crud.sistemavillamarPrueba.controllers;

import com.crud.sistemavillamarPrueba.dao.UsuarioDAO;
import com.crud.sistemavillamarPrueba.models.usuarios;

import com.crud.sistemavillamarPrueba.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private JWTUtil jwutil;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loguearse (@RequestBody usuarios recibido){
      usuarios devuelto=usuarioDAO.verificarcredencial(recibido);
        if (devuelto!=null){

            String tokeniza=jwutil.create(String.valueOf(devuelto.getId_usuario()),devuelto.getEmail());
              return tokeniza;
      }
      return "FAIL";
    }

    @RequestMapping(value = "api")
    public String loguearse (){

        return "FAIL";
    }
}

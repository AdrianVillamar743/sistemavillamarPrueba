package com.crud.sistemavillamarPrueba.controllers;

import com.crud.sistemavillamarPrueba.dao.UsuarioDAO;
import com.crud.sistemavillamarPrueba.models.usuarios;
import com.crud.sistemavillamarPrueba.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private JWTUtil jwtUtil;



    @RequestMapping (value="api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,@PathVariable int id){
        if (!validarToken(token)){
            return;
        }

     usuarioDAO.eliminarUsuarios(id);
    }

    @RequestMapping (value="api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario (@RequestBody usuarios recibido){


      Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
      String hash=  argon2.hash(5,1024,5,recibido.getClave());
      recibido.setClave(hash);

        usuarioDAO.registrar(recibido);
    }







    @RequestMapping (value="api/usuarios")
    public List<usuarios> getUsuarios (@RequestHeader(value="Authorization") String token){
        if (!validarToken(token)){
            return null;
        }
        return usuarioDAO.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioid=jwtUtil.getKey(token);
        return usuarioid!=null;
    }

}

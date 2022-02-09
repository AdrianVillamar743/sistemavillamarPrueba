package com.crud.sistemavillamarPrueba.dao;

import com.crud.sistemavillamarPrueba.models.usuarios;

import java.util.List;

public interface UsuarioDAO {

    List<usuarios> getUsuarios();
   void eliminarUsuarios (int id);
   void registrar(usuarios usuario);
   usuarios verificarcredencial(usuarios usuario);
}

package com.crud.sistemavillamarPrueba.dao;

import com.crud.sistemavillamarPrueba.models.usuarios;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*Repository hace la conexion con la base de datos*/
@Repository
/*Las query enviadas de la bd*/
@Transactional

public class UsuarioDAOImp implements UsuarioDAO{
/*Importante no olvidar el persistence context ni el transactional en cada caso*/
    @PersistenceContext
    EntityManager entityManager;




    @Override
    @Transactional
    public List<usuarios> getUsuarios() {
        String query = "FROM usuarios where estado='A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public void eliminarUsuarios(int id) {

       usuarios usuario =entityManager.find(usuarios.class,id);
       entityManager.remove(usuario);
    }

    @Override
    @Transactional
    public void registrar(usuarios usuario) {
        entityManager.merge(usuario);
    }

    @Override
    @Transactional
    public usuarios verificarcredencial(usuarios usuario) {
        String query = "FROM usuarios where email = :email";
        List<usuarios> listado=entityManager.createQuery(query)
                 .setParameter ("email",usuario.getEmail())
       /*          .setParameter("clave",usuario.getClave())
         */       .getResultList();
         if (listado.isEmpty()){
             return null;
         }

         String hasheadopapu=listado.get(0).getClave();
       Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    if( argon2.verify(hasheadopapu,usuario.getClave())){
        return listado.get(0);
    }
    return null;

    }
}

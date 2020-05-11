package com.anilber.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anilber.modelo.TbUsuariop;



public class UsuariosDao {

public List<TbUsuariop> usuarioLista(TbUsuariop us){
		
		List<TbUsuariop>listaus = new ArrayList<>();
		
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("LoginAnilber");
		em=emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			listaus= em.createQuery("from TbUsuariop as a where a.usuario = '"+us.getUsuario()+"' and a.contrasenia='"+ us.getContrasenia()+"'").getResultList();
			em.getTransaction().commit();
			
			for(TbUsuariop idDatos:listaus){
				
				us.setIdUsuarios(idDatos.getIdUsuarios());
				
			}
			
		} catch (Exception e) {
			System.out.println(e+"Error");
		}
		
		
		
		return listaus;
	}
}

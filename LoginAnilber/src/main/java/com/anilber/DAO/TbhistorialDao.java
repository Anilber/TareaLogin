package com.anilber.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.engine.jdbc.spi.ResultSetReturn;

import com.anilber.modelo.TbHistorial;
import com.mysql.fabric.xmlrpc.base.Array;

public class TbhistorialDao {
	
	public void agregarDatosHistorial(TbHistorial th) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("LoginAnilber");
		em=emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(th);
		em.flush();
		em.getTransaction().commit();
		
	}

	
	
	public List<Object> Historial(){
		List<Object> histo = new ArrayList();
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("LoginAnilber");
		em=emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			histo= em.createQuery("SELECT his.idHistorial, his.tbUsuariop.idUsuarios, his.fecha, "
					+"usu.nombre_usuario, usu.apellido_usuario"
					+" FROM TbHistorial AS his "
					+"INNER JOIN TbUsuariop AS usu ON usu.idUsuarios = his.tbUsuariop.idUsuarios").getResultList();
			
			em.getTransaction().commit();
		
		} catch (Exception e) {
			System.out.println(e+"Errror");
		}
		
		
	return histo;
		
	}
	
	
}

package com.anilber.controlador;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anilber.DAO.TbhistorialDao;
import com.anilber.DAO.UsuariosDao;
import com.anilber.modelo.TbHistorial;
import com.anilber.modelo.TbUsuariop;

/**
 * Servlet implementation class Servelet
 */
public class Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		TbUsuariop tus = new TbUsuariop();

		String id= request.getParameter("Id");
		String nombreu= request.getParameter("Nusuario");
		String apellidou= request.getParameter("Ausuario");
		String usuarioo= request.getParameter("Usuuario");
		String contraseñaa= request.getParameter("Contra");
		
		
		tus.setIdUsuarios(Integer.parseInt(id));
		tus.setNombre_usuario(nombreu);
		tus.setApellido_usuario(apellidou);
		tus.setUsuario(usuarioo);
		tus.setContrasenia(contraseñaa);
		
		
		EntityManager em;
		
		EntityManagerFactory emf;
		
		emf= Persistence.createEntityManagerFactory("LoginAnilber");
		
		em= emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(tus);
		em.flush();
		em.getTransaction().commit();
		
		response.sendRedirect("crearUsuario.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contrasenia");
		String cerrarsesion = request.getParameter("btncerrar");
		
		if(cerrarsesion!=null) {
			
			if(cerrarsesion.equals("CERRAR")) {
				
			HttpSession cerrarsesiones = (HttpSession) request.getSession();
			cerrarsesiones.invalidate();
			
			response.sendRedirect("index.jsp");
				
			}
			
			
		}else {
		
		TbUsuariop tusu = new TbUsuariop();
		UsuariosDao udao= new UsuariosDao();
		
		
		tusu.setUsuario(usuario);
		tusu.setContrasenia(contraseña);
		
		int verificaion= udao.usuarioLista(tusu).size();
		
		if (verificaion ==1) {
			
			TbHistorial tbh = new TbHistorial();
			TbhistorialDao histodao = new TbhistorialDao();
			Date fecha = new Date();
			tbh.setFecha(fecha);
			tusu.setIdUsuarios(tusu.getIdUsuarios());
			tbh.setTbUsuariop(tusu);
			histodao.agregarDatosHistorial(tbh);
			
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("usuarioo", usuario); 
			response.sendRedirect("resultado.jsp");
			
		}else {
			System.out.println("¡Error Usuario o Contraseña equivocada!");
			
		}
		
		
		}
		
		
		
	}
	
	
	

}

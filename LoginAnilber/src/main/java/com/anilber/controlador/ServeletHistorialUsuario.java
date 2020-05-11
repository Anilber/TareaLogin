package com.anilber.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anilber.DAO.TbhistorialDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServeletHistorialUsuario
 */
public class ServeletHistorialUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletHistorialUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		TbhistorialDao ThsitoDao = new TbhistorialDao();
         Gson json= new Gson();
		
		
		try {
			
			response.getWriter().append(json.toJson(ThsitoDao.Historial()));
	
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
		
	}

}

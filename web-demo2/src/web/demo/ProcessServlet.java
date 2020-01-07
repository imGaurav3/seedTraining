package web.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.demo.model.Students;

/**
 * Servlet implementation class ProcessServlet
 */
@WebServlet(urlPatterns =  "/process")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String phone = request.getParameter("phone").trim();
		String batch = request.getParameter("batch").trim();
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(batch);
		
		Students s = new Students(name,email,phone,batch);
		
		List<Students> students = null;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("students") == null) {
			students = new ArrayList<>();
		}else {
			students = (List<Students>) session.getAttribute("students");
		}
		students.add(s);
		
		session.setAttribute("students", students);
		
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

}

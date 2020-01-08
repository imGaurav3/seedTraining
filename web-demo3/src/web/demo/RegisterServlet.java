package web.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import web.demo.model.Students;
import web.demo.model.StudentsDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nm_del = request.getParameter("del_name").trim();
		String nm_edit = request.getParameter("edit_name").trim();
		
		System.out.println(nm_del);
		System.out.println(nm_edit);
		
		if(request.getParameter("delBtn")!=null) {
			
			//Students s = get
			StudentsDao.delete(nm_del);
			//StudentsDao.shutdown();
		}
		else if(request.getParameter("editBtn")!=null) {
			
			StudentsDao.tblUpdate(nm_edit, "x@gmail.com");
			//StudentsDao.shutdown();
		}
		
		List<Students> students = null;
		students = StudentsDao.display();
		
		
		
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("page2.jsp").forward(request, response);
		
		
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
		
		Students student = new Students(name, email, phone, batch);
		StudentsDao.create(student);
		
		List<Students> students = null;
		students = StudentsDao.display();
		
		//StudentsDao.shutdown();
		
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

}

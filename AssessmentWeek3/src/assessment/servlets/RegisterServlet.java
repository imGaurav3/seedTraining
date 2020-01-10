package assessment.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assessment.models.ClinicDao;
import assessment.models.Medicine;
import assessment.models.Patient;
import assessment.models.Prescription;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public static int count = 2;
	
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String prescription_id = request.getParameter("prescription_id").trim();
		int presID = Integer.parseInt(prescription_id);
		
		String patient_id = request.getParameter("patient_id").trim();
		int patID = Integer.parseInt(patient_id);
		
		String regDate = request.getParameter("date").trim();
		
		String medicine_id = request.getParameter("prescription_id").trim();
		int medID = Integer.parseInt(medicine_id);
		
		String med_name = request.getParameter("med_name").trim();
		
		Patient p = ClinicDao.findOne(patID);
		Prescription prescription = new Prescription(presID, regDate, p);
		
		List<Prescription> presList = null;
		presList.add(prescription);
		
		Medicine m = new Medicine(medID, med_name, presList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String regDate = request.getParameter("date").trim();
		
		Patient patient = new Patient(count++,name, email, regDate);
		ClinicDao.createPatient(patient);
		
		List<Patient> patients = null;
		patients = ClinicDao.displayPatient();
		
		request.setAttribute("patients", patients);
		request.getRequestDispatcher("registerPatient.jsp").forward(request, response);
	}

}

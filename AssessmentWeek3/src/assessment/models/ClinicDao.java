package assessment.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;



public class ClinicDao {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public ClinicDao() {
		
	}
	
	
	public static void createPatient(Patient obj) {
		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		}
	}
	
	public static void createPrescription(Prescription obj) {
		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		}
	}
	
	public static void createMedicine(Medicine obj) {
		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		}
	}
	
	public static List<Patient> displayPatient(){
		String query = "select e from Patient e";
		List<Patient> stud = null;
		
		try(Session session = getSessionFactory().openSession()){
			Query<Patient> q = session.createQuery(query,Patient.class);
			stud = q.getResultList();
		}
		return stud;
	}
	
	public static List<Prescription> displayPrescription(){
		String query = "select e from Prescription e";
		List<Prescription> stud = null;
		
		try(Session session = getSessionFactory().openSession()){
			Query<Prescription> q = session.createQuery(query,Prescription.class);
			stud = q.getResultList();
		}
		return stud;
	}
	
	public static List<Medicine> displayMedicine(){
		String query = "select e from Medicine e";
		List<Medicine> stud = null;
		
		try(Session session = getSessionFactory().openSession()){
			Query<Medicine> q = session.createQuery(query,Medicine.class);
			stud = q.getResultList();
		}
		return stud;
	}
	
	
	public static Patient findOne(int id) {
		Patient p = null;
		try(Session session = getSessionFactory().openSession()){
			p = session.get(Patient.class,id);
		}
		return p;
	}
	
	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}

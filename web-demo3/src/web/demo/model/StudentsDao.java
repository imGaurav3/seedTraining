package web.demo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;



public class StudentsDao {
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public StudentsDao() {
		
	}
	public static void create(Students obj) {
		try (Session session = getSessionFactory().openSession()) {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		}
	}
	public static List<Students> display(){
		String query = "select e from Students e";
		List<Students> stud = null;
		
		try(Session session = getSessionFactory().openSession()){
			Query<Students> q = session.createQuery(query,Students.class);
			stud = q.getResultList();
		}
		return stud;
	}
	public static void delete(String nm) {
		//String query = "delete from Students e where name = 'nm'";
		try(Session session = getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.delete(session.get(Students.class, nm));
			session.getTransaction().commit();
		}
	}
	
	public static void update(String nm) {
		try(Session session = getSessionFactory().openSession()){
			session.getTransaction().begin();
			session.update(session.get(Students.class, nm));
			session.getTransaction().commit();
		}
	}
	public static void tblUpdate(String nm,String newEm) {
		String query = "update Students e set e.email = :newEm where e.name = :nm";
		try(Session session = getSessionFactory().openSession()){
			Query q = session.createQuery(query);
			session.getTransaction().begin();
			q.setParameter("newEm", newEm);
			q.setParameter("nm", nm);
			System.out.println(q.executeUpdate());
			session.getTransaction().commit();
		}
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

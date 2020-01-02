package hb.demo2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import hb.demo2.model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		Transaction transaction = null;

		try (Session session = getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Teacher b = new Teacher(106, "Shamla", "EnTC", 39);
			session.save(b);
			transaction.commit();
			shutdown();
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
	
	public static void shutdown() {
		if(registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
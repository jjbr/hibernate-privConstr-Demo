package testpckg;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class Main {
	public static void main(String[] args) {
		B b = new B();

		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");

		conf.addAnnotatedClass(A.class)
				.addAnnotatedClass(B.class);

		EntityManager entityManager = null;

		try {
			entityManager = conf.buildSessionFactory().createEntityManager();
			entityManager.getTransaction().begin();

			entityManager.persist(b);
			entityManager.getTransaction().commit();

			entityManager.clear();

			int bId = b.getId();

			// Fails
			B retB = entityManager.getReference(B.class, bId);

			System.out.println(retB);

		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}

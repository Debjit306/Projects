package com.libary;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Libary.class);

		// Create Session Factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Initialize Session Object
		Session session = sessionFactory.openSession();

		Libary book1 = new Libary();
		Libary book2 = new Libary();

		book1.setId(1);
		book1.setBookName("Byomkesh Bakshi");
		book1.setPublisherName("Shibharam Chakraborty");
		book1.setDateOfPublish(20);

		book2.setId(2);
		book2.setBookName("Darjeling Jom Jomat Feluda");
		book2.setPublisherName("Satyajit Ray");
		book2.setDateOfPublish(30);

		session.beginTransaction();

		// Here we have used
		// save() method of JPA
		session.save(book1);
		session.save(book2);

		session.getTransaction().commit();
	}
}

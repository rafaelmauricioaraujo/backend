package br.dev.rafael.cyberspace.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCreateTable {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cyberspace_jpa");
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
	}

}

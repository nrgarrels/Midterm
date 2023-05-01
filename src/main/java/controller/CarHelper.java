package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Cars;

public class CarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Cars");

	public void insertShopper(Cars c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Cars> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<Cars> allCars = em.createQuery("SELECT c from Cars c").getResultList();
		return allCars;
	}
	

}

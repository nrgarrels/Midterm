package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ListCar;
import model.ListCarPart;

public class ListCarPartHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarParts");
	
	public void insertCarPart(ListCarPart li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ListCar> showAllCarParts(){
		EntityManager em = emfactory.createEntityManager();
		List<ListCar> allCars = em.createQuery("SELECT i from ListCarPart i").getResultList();
		return allCars;
		
	}
}

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListCar;


public class ListCarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Cars");
	
	public void insertCar(ListCar li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ListCar> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<ListCar> allCars = em.createQuery("SELECT i from ListCars i").getResultList();
		return allCars;
		
	}

	public void deleteCar(ListCar toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar> typedQuery = em.createQuery("select li from ListCar li where li.id = :selectedCar", ListCar.class);
		
		typedQuery.setParameter("selectedCar", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		ListCar result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListCar searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		ListCar found = em.find(ListCar.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCar(ListCar toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListCar> searchForCarPartByCar(String carName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar> typedQuery = em.createQuery("select li from ListCar li where li.car = :selectedCar", ListCar.class);
		
		typedQuery.setParameter("selectedCar", carName);
		
		List<ListCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ListCar> searchForCarByCar(String carPartName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCar> typedQuery = em.createQuery("select li from ListCars li where li.carPart = :selectedCarPart", ListCar.class);
		
		typedQuery.setParameter("selectedCarPart", carPartName);
		
		List<ListCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
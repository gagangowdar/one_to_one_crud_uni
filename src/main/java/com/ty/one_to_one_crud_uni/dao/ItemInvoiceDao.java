package com.ty.one_to_one_crud_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.one_to_one_crud_uni.dto.Invoice;
import com.ty.one_to_one_crud_uni.dto.Item;

public class ItemInvoiceDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void save(Invoice invoice, Item item) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityManager.persist(invoice);
		entityTransaction.commit();
	}

	public Invoice getInvoice(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Invoice invoice = entityManager.find(Invoice.class, id);
		entityTransaction.commit();
		return invoice;
	}

	public void updateInvoice(Invoice invoice) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(invoice);
		entityTransaction.commit();
	}

	public void delete(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Invoice invoice = entityManager.find(Invoice.class, id);
		if (invoice != null) {
			Item item = invoice.getItem();
			entityManager.remove(invoice);
			if (item != null) {
				entityManager.remove(item);
			}
			entityTransaction.commit();
		}

	}

}

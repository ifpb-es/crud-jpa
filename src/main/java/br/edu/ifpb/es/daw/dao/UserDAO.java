package br.edu.ifpb.es.daw.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import br.edu.ifpb.es.daw.entities.User;

public class UserDAO extends DAO {

	public UserDAO(EntityManagerFactory emf) {
		super(emf);
	}

	public void save(User user) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				em.persist(user);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar salvar o usuário.", pe);
			}
		}
	}

	public User update(User user) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			User resultado = user;
			try {
				resultado = em.merge(user);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar atualizar o usuário.", pe);
			}
			return resultado;
		}
	}

	public void delete(User user) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				user = em.find(User.class, user.getId());
				em.remove(user);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar remover o usuário.", pe);
			}
		}
	}

	public User getByID(int userId) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			User resultado = null;
			try {
				resultado = em.find(User.class, userId);
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar o usuário com base no ID.", pe);
			}
			return resultado;
		}
	}

	public List<User> getAll() throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			List<User> resultado = null;
			try {
				TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
				resultado = query.getResultList();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
			}
			return resultado;
		}
	}
}

package br.edu.ifpb.es.daw;

import java.time.LocalDate;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.entities.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDelete {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			UserDAO dao = new UserDAOImpl(emf);
			// Primeiro salvar
			User user = new User();

			user.setBirthday(LocalDate.now());
			user.setEmail("email@gmail.com");
			user.setFirstName("Sicrano");
			user.setLastName("Silva");

			dao.save(user);

			System.out.println(dao.getAll().size());

			// Depois apagar

			dao.delete(user.getId());

			System.out.println(dao.getAll().size());
		}
	}

}

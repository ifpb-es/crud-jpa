package br.edu.ifpb.es.daw;

import java.time.LocalDate;
import java.util.Date;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.entities.User;

public class MainGetByID {

	public static void main(String[] args) throws DawException {
		UserDAO dao = new UserDAO();
		try {
			// Primeiro salvar
			User user = new User();

			user.setBirthday(LocalDate.now());
			user.setEmail("email@gmail.com");
			user.setFirstName("Sicrano");
			user.setLastName("Silva");

			dao.save(user);

			// Depois recuperar pelo identificador

			User resultado = dao.getByID(user.getId());

			System.out.println(user.equals(resultado));
		} finally {
			dao.close();
		}
	}

}

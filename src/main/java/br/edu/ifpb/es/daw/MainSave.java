package br.edu.ifpb.es.daw;

import java.time.LocalDate;
import java.util.Date;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.entities.User;

public class MainSave {

	public static void main(String[] args) throws DawException {
		UserDAO dao = new UserDAO();
		try {
			User user = new User();

			user.setBirthday(LocalDate.now());
			user.setEmail("email@gmail.com");
			user.setFirstName("Sicrano");
			user.setLastName("Silva");

			System.out.println(user);
			
			dao.save(user);

			System.out.println(user);
		} finally {
			dao.close();
		}
	}

}

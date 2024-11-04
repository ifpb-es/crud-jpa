package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.entities.User;

public class MainGetAll {

	public static void main(String[] args) throws DawException {

		UserDAO dao = new UserDAO();
		try {
			List<User> usuarios = dao.getAll();

			for (User user : usuarios) {
				System.out.println(user);
			}

		} finally {
			dao.close();
		}
	}

}

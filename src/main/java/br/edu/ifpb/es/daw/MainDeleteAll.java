package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.entities.User;

public class MainDeleteAll {

	public static void main(String[] args) throws DawException {
		UserDAO dao = new UserDAO();
		try {
			List<User> usuarios = dao.getAll();
			for (User usuario : usuarios) {
				dao.delete(usuario);
			}
		} finally {
			dao.close();
		}
	}

}

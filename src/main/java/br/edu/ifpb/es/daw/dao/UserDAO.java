package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.User;

import java.util.List;

public interface UserDAO {

    void save(User user) throws PersistenciaDawException;

    User update(User user) throws PersistenciaDawException;

    void delete(User user) throws PersistenciaDawException;

    User getByID(int userId) throws PersistenciaDawException;

    List<User> getAll() throws PersistenciaDawException;
}

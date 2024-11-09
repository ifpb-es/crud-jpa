package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.User;

import java.util.List;

public interface UserDAO {

    void save(User user) throws PersistenciaDawException;

    User update(User user) throws PersistenciaDawException;

    void delete(Integer userId) throws PersistenciaDawException;

    User getByID(Integer userId) throws PersistenciaDawException;

    List<User> getAll() throws PersistenciaDawException;
}

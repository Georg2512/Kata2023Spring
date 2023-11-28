package web.service;


import web.dao.UserDaoHibernateImpl;
import web.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> user = userDaoHibernate.getAllUsers();
        //user.forEach(System.out::println);
        return user;
    }

    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }
}

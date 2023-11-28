package web.dao;

import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import web.model.User;
import web.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {


    SessionFactory sessionFactory = new Util().getSessionFactory();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable()  {
        /*try (Session session = sessionFactory.getCurrentSession()) {
            String sql = "CREATE TABLE users(" +
                    "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                    "name VARCHAR(30) NOT NULL," +
                    "lastname VARCHAR(30) NOT NULL," +
                    "age INT(3) NULL)";
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        }*/
    }


    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.getCurrentSession()) {
            String sql = "DROP TABLE users";
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(new User());
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
            criteriaQuery.from(User.class);
            Transaction transaction = session.beginTransaction();
            userList = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
            return userList;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("DELETE FROM users").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
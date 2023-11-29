package web.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import web.model.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findOne(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {

        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    @Transactional
    public void update(Long id, User user) {

        entityManager.merge(user);
    }
}
//
//
//
//
//    @Override
//    public void cleanUsersTable() {
//        /*try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.createNativeQuery("DELETE FROM users").executeUpdate();
//            transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }*/
//    }
//    @Override
//    public void createUsersTable()  {
//        /*try (Session session = sessionFactory.getCurrentSession()) {
//            String sql = "CREATE TABLE users(" +
//                    "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
//                    "name VARCHAR(30) NOT NULL," +
//                    "lastname VARCHAR(30) NOT NULL," +
//                    "age INT(3) NULL)";
//            session.beginTransaction();
//            session.createNativeQuery(sql).executeUpdate();
//            session.getTransaction().commit();
//        }*/
//    }
//
//
//    @Override
//    public void dropUsersTable() {
//        /*try (Session session = sessionFactory.getCurrentSession()) {
//            String sql = "DROP TABLE users";
//            session.beginTransaction();
//            session.createNativeQuery(sql).executeUpdate();
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }*/
//    }

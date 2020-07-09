package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query =
                sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public User getUserByCar(Car car) {
        Query<Car> query =
                sessionFactory.getCurrentSession().createQuery(
                        "FROM Car WHERE name = :carName AND series = :carSeries");
        query.setParameter("carName", car.getName());
        query.setParameter("carSeries", car.getSeries());
        car = query.getResultList().get(0);
        Query<User> query1 =
                sessionFactory.getCurrentSession().createQuery(
                        "FROM User WHERE car_series = :carSeries");
        query1.setParameter("carSeries", car.getSeries());
        return query1.getResultList().get(0);
    }
}

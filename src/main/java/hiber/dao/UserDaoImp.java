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
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public User getUserForCarId(long id_car) {
      String hql = "FROM User as u WHERE u.car.id = '" + id_car + "'";
      return (User) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
   }

   @Override
   public User getUserForCarSeries(int series_car) {
      String hql = "FROM User as u WHERE u.car.series = '" + series_car + "'";
      return (User) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}

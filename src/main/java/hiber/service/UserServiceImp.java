package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void add(Car car) {
      userDao.add(car);
   }

   @Transactional
   @Override
   public User getUserForCarId(long id_car) {
      return userDao.getUserForCarId(id_car);
   }

   @Transactional
   @Override
   public User getUserForCarSeries(int series_car) {
      return userDao.getUserForCarSeries(series_car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}

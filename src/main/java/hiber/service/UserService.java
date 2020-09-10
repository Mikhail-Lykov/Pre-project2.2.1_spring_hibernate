package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void add(Car car);
    User getUserForCarId(long id_car);
    User getUserForCarSeries(int series_car);
    List<User> listUsers();
}

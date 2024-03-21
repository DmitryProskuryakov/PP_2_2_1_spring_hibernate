package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> getUser(String model, int session);

    void add(User user);

    List<User> listUsers();
}

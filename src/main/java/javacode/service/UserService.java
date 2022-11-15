package javacode.service;

import javacode.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void delete(User person);

    void edit(User person);

    void add(User user);

    User findById(Long id);

    List<User> listUser();

    List<User> findAllKids(int age);

    void addByAdmin(User user);
}

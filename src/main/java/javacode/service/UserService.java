package javacode.service;

import javacode.model.Users;

import java.util.List;

public interface UserService {

    void delete(Users person);

    void edit(Users person);

    void add(Users user);

    Users findById(Long id);

    List<Users> listUser();

    List<Users> findAllKids(int age);

}

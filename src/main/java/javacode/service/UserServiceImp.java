package javacode.service;

import javacode.dao.UserDao;
//import javacode.dao.UserDaoImp;
import javacode.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(Users user) {
        userDao.save(user);
        //userDao.add(user);
    }

    @Override
    public Users findById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<Users> listUser() {
        List<Users> personList = new ArrayList<>();
        userDao.findAll().forEach(personList::add);
        return personList;
        // return userDao.listUser();
    }

    @Override
    public void delete(Users person) {
        userDao.delete(person);
    }

   /* @Override
    public void edit(Long id, Users personToUpdate) {
        //  Optional<Users> user = userDao.findById(personToUpdate.getId());
        Optional<Users> user = userDao.findById(id);
        if (user.isPresent()) {
            Users updatedPerson = user.get();
            updatedPerson.setLogin(personToUpdate.getLogin());
            updatedPerson.setPassword(personToUpdate.getPassword());
            updatedPerson.setAge(personToUpdate.getAge());
            userDao.save(updatedPerson);
            System.out.println("User with id:" + personToUpdate.getId() + " was updated: " + updatedPerson);
            return;
        }
        System.out.println("Smth went wrong with update");
    }*/
    @Override
    public void edit(Users personToUpdate) {
        //  Optional<Users> user = userDao.findById(personToUpdate.getId());
        Long id = personToUpdate.getId();
        Optional<Users> user = userDao.findById(id);
        System.out.println(user);
        if (user.isPresent()) {
            Users updatedPerson = user.get();
            updatedPerson.setLogin(personToUpdate.getLogin());
            updatedPerson.setPassword(personToUpdate.getPassword());
            updatedPerson.setAge(personToUpdate.getAge());
            userDao.save(updatedPerson);
            System.out.println("User with id:" + personToUpdate.getId() + " was updated: " + updatedPerson);
            return;
        }
        System.out.println("Smth went wrong with update");
    }

    @Override
    public List<Users> findAllKids(int age) {
        List<Users> personList = new ArrayList<>();
        userDao.findAllByAgeBefore(age).forEach(personList::add);
        return personList;
    }

}
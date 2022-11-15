package javacode.service;

import javacode.dao.RoleDao;
import javacode.dao.UserDao;
import javacode.model.Role;
import javacode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void add(User user) {
        user.setRoles(Collections.singleton(roleDao.findRoleByName("ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user);
        userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> listUser() {
        List<User> personList = new ArrayList<>();
        userDao.findAll().forEach(personList::add);
        return personList;
    }

    @Override
    public void delete(User person) {
        userDao.delete(person);
    }

    @Override
    public void edit(User personToUpdate) {
        Long id = personToUpdate.getId();
        Optional<User> user = userDao.findById(id);
        System.out.println(user);
        if (user.isPresent()) {
            User updatedPerson = user.get();
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
    public List<User> findAllKids(int age) {
        return new ArrayList<>(userDao.findAllByAgeBefore(age));
    }

    @Override
    public void addByAdmin(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user);
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDao.findByLogin(username);
        System.out.println("Load user by name "+ username +"!");

        if (user.isEmpty()){
            throw new UsernameNotFoundException("User doesn't exists");
        }
        return user.get();
    }


}
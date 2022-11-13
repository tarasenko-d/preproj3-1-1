
package javacode.dao;

import javacode.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    List<User> findAllByAgeBefore(int age);

    Optional<User> findById(Long id);

    Optional<User> findByLogin(String login);
}




package javacode.dao;

import javacode.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<Users, Long> {

    List<Users> findAllByAgeBefore(int age);

    Optional<Users> findById(Long id);
}



package javacode;

import javacode.dao.RoleDao;
import javacode.dao.UserDao;
import javacode.model.Role;
import javacode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RunAfterStartup {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        System.out.println("I am running........");

        if (!roleDao.existsRolesByName("ROLE_ADMIN")) {
            System.out.println("Role Admin doesnt exist before");
            roleDao.save(new Role("ROLE_ADMIN"));
        }
        if (!roleDao.existsRolesByName("ROLE_USER")) {
            System.out.println("Role User doesnt exist before");
            roleDao.save(new Role("ROLE_USER"));
        }

        if (!userDao.findByLogin("admin").isPresent()) {
            User admin = new User("admin", "admin", 18);
            admin.setRoles(Collections.singleton(roleDao.findRoleByName("ROLE_ADMIN")));
            System.out.println(roleDao.findRoleByName("ROLE_ADMIN"));
            admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
            System.out.println(admin);
            userDao.save(admin);
        }
        if (!userDao.findByLogin("user").isPresent()) {
            User user = new User("user", "user", 20);
            user.setRoles(Collections.singleton(roleDao.findRoleByName("ROLE_USER")));
            System.out.println(roleDao.findRoleByName("ROLE_USER"));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            System.out.println(user);
            userDao.save(user);
        }

    }
}


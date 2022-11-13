package javacode.controller;

import javacode.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RoleController {

    @RequestMapping("/")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            System.out.println("You are admin");
            return "redirect:/list";
        }
        return "redirect:/user";
    }


    @GetMapping("/user")
    public ModelAndView getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        return new ModelAndView("user", params);
    }
}


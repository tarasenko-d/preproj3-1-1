package javacode.controller;

import javacode.model.User;
import javacode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView getList() {
        List<User> userList = userService.listUser();
        Map<String, Object> params = new HashMap<>();
        params.put("userList", userList);
        return new ModelAndView("index", params);
    }

    @GetMapping("/kids")
    public ModelAndView kids(@RequestParam int age) {
        List<User> personList = userService.findAllKids(age);
        Map<String, Object> params = new HashMap<>();
        params.put("userList", personList);
        return new ModelAndView("ages", params);
    }


    @PostMapping(value = "/save")
    public String add_post(Model model, @ModelAttribute("user") User user) {
        System.out.println("add controller");
        userService.add(user);
        return "redirect:/list";
    }

    @PostMapping(value = "/admin/add")
    public String postAdd_admin(@ModelAttribute("user") User user) {
        System.out.println("add admin");
        userService.addByAdmin(user);
        return "save";
    }
    @GetMapping(value = "/admin/add")
    public String getAdd_admin() {
        return "save";
    }


    @GetMapping(value = "/save")
    public String add_get(Model model, @ModelAttribute("user") User user) {
        System.out.println("add controller");
      //  userService.add(user);
        return "save";
    }

    @GetMapping(value = "/admin/delete")
    public String deleteUser(@RequestParam Long id) {
        User userToDelete = userService.findById(id);
        userService.delete(userToDelete);
        return "redirect:/list";
    }

    @GetMapping(value = "/admin/edit")
    public ModelAndView editUser(@RequestParam Long id) {
        User userToEdit = userService.findById(id);
        Map params = new HashMap<String, Object>();
        params.put("userToEdit", userToEdit);
        System.out.println(userToEdit);
        return new ModelAndView("edit", params);
    }

    @PostMapping(value = "/admin/edit")
    public String edit(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.edit(user);
        return "redirect:/list";
    }

}
////TODO
//save

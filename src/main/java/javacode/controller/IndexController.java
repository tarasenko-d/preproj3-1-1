package javacode.controller;

import javacode.model.Users;
import javacode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView getList() {
        var userList = userService.listUser();
        var params = new HashMap<String, Object>();
        params.put("userList", userList);
        return new ModelAndView("index", params);
    }

    @GetMapping("/kids")
    public ModelAndView kids(@RequestParam int age) {
        var personList = userService.findAllKids(age);
        var params = new HashMap<String, Object>();
        params.put("userList", personList);
        return new ModelAndView("ages", params);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("user") Users user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam Long id) {
        Users userToDelete = userService.findById(id);
        userService.delete(userToDelete);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editUser(@RequestParam Long id) {
        Users userToEdit = userService.findById(id);
        var params = new HashMap<String, Object>();
        params.put("userToEdit", userToEdit);
        System.out.println(userToEdit);
        return new ModelAndView("edit", params);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("user") Users user) {
        System.out.println(user);
        userService.edit(user);
        return "redirect:/";
    }

}
////TODO
//как передавать модель в контроллер(RequestBody)
//save
// ->post
//REST как писать запросы url


/*   @GetMapping("/add")
       public Users addUser() {
          Users person = new Users();
           model.addObject("user", person);
           return model;
       }
   */
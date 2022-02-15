package com.athira.fleetapp.controllers;

import com.athira.fleetapp.entities.User;
import com.athira.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //Get All Users
    @GetMapping("/users")
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "user";
    }

    @RequestMapping("users/findById")
    @ResponseBody
    public User findById(Integer id)
    {
        return userService.findById(id);
    }

    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redirectAttributes) {

        userService.save(user);

        RedirectView  redirectView= new RedirectView("/login",true);

        redirectAttributes.addFlashAttribute("message",	"User successfully registered!");

        return redirectView;
//        RedirectAttributes called Flash attributes, it will redirect to the page with the attributes(here msg) passing to the view.
//    addFlashAttribute() actually stores the attributes in a flash map
//    --(which is internally maintained in the users session and removed once the next redirected request gets fulfilled)
    }

    @RequestMapping(value="/users/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

}

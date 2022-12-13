package com.company.app.controller;

import com.company.app.Service.ClientService;
import com.company.app.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    ClientService clientService;

    @RequestMapping({"/", "/home"})
    public String home()
    {
        return "home";
    }
    @RequestMapping(value ={"/", "/home"}, method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String email, @RequestParam String password)
    {
        ModelAndView modelAndView=new ModelAndView("client");
        ModelAndView modelError=new ModelAndView("home");

      if (clientService.login(email, password)=="true")
      {
          return modelAndView.addObject("Bienvenue",
                  "Bienvenue dans notre interface et profitez-vous de nos promotion"+clientService.login(email, password));
      }

     else
      {
          return modelError.addObject("error",
                  "Vos informations sont incorectes!"+clientService.login(email, password));
      }
    }
}

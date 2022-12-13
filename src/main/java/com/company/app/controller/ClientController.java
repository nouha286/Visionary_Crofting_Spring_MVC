package com.company.app.controller;

import com.company.app.Service.ClientService;
import com.company.app.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientController
{
    @Autowired
    ClientService clientService;

    @RequestMapping("/client")
    public ModelAndView client()
    {
        ModelAndView modelAndView=new ModelAndView("client");
        List<Client> getAllClients=clientService.getAllClients();
        modelAndView.addObject("listClient",getAllClients);
        return modelAndView;
    }


}

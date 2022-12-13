package com.company.app.controller;

import com.company.app.Dto.Pannier;
import com.company.app.Dto.PasserCommande;
import com.company.app.Service.CommandItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommandItemController {





    @Autowired
    CommandItemService commandItemService;
    @Autowired
    Pannier pannier;


    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ModelAndView addCommandItem(@ModelAttribute("passerCommande") PasserCommande passerCommande)
    {

        pannier.setCommandItemList(passerCommande);
        ModelAndView modelAndView=new ModelAndView("Product");

        return modelAndView.addObject("success",
                "ce produit est ajouté au pannier!"+passerCommande);
    }
}

package com.company.app.controller;

import com.company.app.Dto.Pannier;
import com.company.app.Service.ClientService;
import com.company.app.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommandController
{
    @Autowired
    ClientService clientService;
    @Autowired
    Pannier pannier;
    @Autowired
    ProductService productService;

    @RequestMapping()
    public String getPannier(Model model)
    {

       model.addAttribute("commandItemList",pannier.getProduct());
        productService.getProductFromPannier();

       return "pannier";
    }
}

package com.company.app.controller;


import com.company.app.Service.ProductService;
import com.company.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/product")
    public ModelAndView getAllProducts()
    {
        ModelAndView modelAndView=new ModelAndView("Product");
        List<Product> productList=productService.getAllProducts();
        modelAndView.addObject("ListProduit",productList);
        return modelAndView;
    }

    @RequestMapping("/stock")
    public ModelAndView page()
    {
        ModelAndView modelAndView=new ModelAndView("stock");
        return modelAndView;
    }

    @RequestMapping(value = "/stock", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("product") Product product)
    {
        productService.addProduct(product);


        ModelAndView modelAndView=new ModelAndView("stock");
         modelAndView.addObject("success","a product is added successfully");
        return modelAndView;


    }
}

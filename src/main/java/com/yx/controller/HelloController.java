package com.yx.controller;

import com.yx.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    BaseDAO baseDAO;

    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", baseDAO.read("Test"));
        baseDAO.save("Test", String.valueOf(System.currentTimeMillis()));
        return "login";
    }

    @RequestMapping(value = "jsp", method = RequestMethod.GET)
    public String printJSP(ModelMap model) {
        model.addAttribute("message", baseDAO.read("Test"));
        baseDAO.save("Test", String.valueOf(System.currentTimeMillis()));
        return "jsp";
    }

    @RequestMapping(value = "freeMarker", method = RequestMethod.GET)
    public String printFreeMarker(ModelMap model) {
        model.addAttribute("message", baseDAO.read("Test"));
        baseDAO.save("Test", String.valueOf(System.currentTimeMillis()));
        return "freeMarker";
    }
}
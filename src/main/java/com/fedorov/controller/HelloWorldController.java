package com.fedorov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //need a controller method to show the initial html form
    // /showForm - address

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //need a controller method to process the html form

    @RequestMapping("/processForm")
    public String processForm () {
        return "helloworld";
    }


    //new a controller method to read from data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude (HttpServletRequest request, Model model) {
        //read the request parameter from the html form
        String theName = request.getParameter("studentName");

        //convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Yo!! From v.2 " + theName;

        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFromVersionThree (@RequestParam("studentName") String theName, Model model) {
        //convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Hey From Version 3!! " + theName;

        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }


}



















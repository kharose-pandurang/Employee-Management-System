package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Data;
import com.example.demo.service.DataService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DemoController {
	
	
	
	@Autowired
	DataService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Data> data= service.getAll();
		m.addAttribute("data",data);
		return "index";
	}
	
	@GetMapping("/add")
	public String addD()
	{
		return "add";
	}
	
	@PostMapping("/addData")
	public String addData(@ModelAttribute Data data,HttpSession session)
	{
		System.out.println(data);
		service.add(data);
		session.setAttribute("msg", "Data Added Sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id ,Model m)
	{
		Data data=service.fingById(id);
		  m.addAttribute("data",data);
		  return "edit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Data data,HttpSession session)
	{
		service.update(data);
		session.setAttribute("msg", "Data Updated Sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session)
	{
		 service.delete(id);
		 session.setAttribute("msg", "Data Delete Sucessfully...");
		 return "redirect:/";
	}

}

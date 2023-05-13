package com.example.weinv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weinv.entity.Company;
import com.example.weinv.service.CompanyService;

@RestController
@RequestMapping("api")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("cmp/{id}")
	public Company getCmpById(@PathVariable int id) {
		return companyService.findCmp(id);
	}
	
	@PostMapping("cmp")
	public void createCmp(@RequestBody Company cmp) {
		companyService.createCmp(cmp);
	}
	
	@PutMapping("cmp")
	public void editCmp(@RequestBody Company cmp) {
		companyService.editCmp(cmp);
	}
	
	@DeleteMapping("cmp/{id}")
	public void deleteCmp(@PathVariable int id) {
		companyService.deleteCmp(id);
	}
}

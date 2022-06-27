package com.marjana.smartwork.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.marjana.smartwork.entity.Name;
import com.marjana.smartwork.service.NameService;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
@RestController
public class NameController {

	@Autowired
	NameService nameService;
	
	@GetMapping(value = "/n")
	public ResponseEntity<List<Name>> getAllNames()
	{
		List<Name> n = nameService.getAllNames();
		return ResponseEntity.ok(n);

	}
	
	@GetMapping(value = "/na/{id}")
	public ResponseEntity<Name> getByIdName(@PathVariable Long id)
	{
		Name na = nameService.findById(id);
		return ResponseEntity.ok(na);
	}
	
	
	@PostMapping("/nam")
	public ResponseEntity<Name> creanam(@RequestBody Name nam) 
	{
		Name dto = nameService.save(nam);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/name/{id}")
	public ResponseEntity<Name> updaten(@RequestBody Name name, @PathVariable Long id) 
	{
		Name dto = nameService.update(name, id);
		return ResponseEntity.ok(dto);
	}
	
	
	
	@DeleteMapping("/named/{id}")
	public ResponseEntity<Name> deleteName(@PathVariable Long id) 
	{
		Name named = nameService.delete(id);
		if(named==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok(named);
	}
	
	
	
}

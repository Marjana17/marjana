package com.marjana.smartwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.marjana.smartwork.entity.Name;
import com.marjana.smartwork.entity.PhoneBook;
import com.marjana.smartwork.service.PhoneBookService;



@RequestMapping("/api")
@RestController

public class PhoneBookController {
	
	@Autowired
	PhoneBookService phoneBookService;
	
	@GetMapping(value = "/phoneBook")
	public ResponseEntity<List<PhoneBook>> getAllPhoneBooks()
	{
		List<PhoneBook> phoneBook = phoneBookService.getAllPhoneBooks();
		return ResponseEntity.ok(phoneBook);
	}
	
	
	
	
	
	@GetMapping(value = "/phoneBook/{id}")
	public ResponseEntity<PhoneBook> getByIdPhoneBook(@PathVariable Long id)
	{
		PhoneBook phoneBook = phoneBookService.findById(id);
		return ResponseEntity.ok(phoneBook);
	}
	
	
	
	@PostMapping("/phoneBook")
	public ResponseEntity<PhoneBook> creap(@RequestBody PhoneBook p) 
	{
		PhoneBook dto = phoneBookService.save(p);
		return ResponseEntity.ok(dto);
	}
	
	
	
	@DeleteMapping("/p/{id}")
	public ResponseEntity<PhoneBook> deletePhoneBook(@PathVariable Long id) 
	{
		PhoneBook dto = phoneBookService.delete(id);
		if(dto==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok(dto);
	}
	
	
	
	
	@PutMapping("/phoneBook/{id}")
	public ResponseEntity<PhoneBook> updatep(@RequestBody PhoneBook p, @PathVariable Long id) 
	{
		PhoneBook dto = phoneBookService.update(p, id);
		return ResponseEntity.ok(dto);
	}
}

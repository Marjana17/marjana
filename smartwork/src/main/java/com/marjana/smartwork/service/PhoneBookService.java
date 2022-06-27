package com.marjana.smartwork.service;

import java.util.List;

import com.marjana.smartwork.entity.PhoneBook;

public interface PhoneBookService {
List<PhoneBook> getAllPhoneBooks();
	
	PhoneBook findById(Long id);
	PhoneBook save(PhoneBook dto);
	PhoneBook update(PhoneBook dto, Long id);
	PhoneBook delete(Long id);


}

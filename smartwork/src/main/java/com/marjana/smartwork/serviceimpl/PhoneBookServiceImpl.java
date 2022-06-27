package com.marjana.smartwork.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marjana.smartwork.entity.PhoneBook;
import com.marjana.smartwork.repository.PhoneBookRepository;
import com.marjana.smartwork.service.NameService;
import com.marjana.smartwork.service.PhoneBookService;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {
	
	@Autowired
	PhoneBookRepository phoneBookRepository;

	@Override
	public List<PhoneBook> getAllPhoneBooks() {
		List<PhoneBook> phoneBook = phoneBookRepository.findAll();
		return phoneBook;
	}

	
	@Override
	public PhoneBook findById(Long id) {
		PhoneBook p = phoneBookRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find Name"));
		return p;
	}
	

	@Override
	@Transactional
	public PhoneBook  save(PhoneBook dto) {
		PhoneBook p = phoneBookRepository.save(dto);
		return p;

	}

	
	@Override
	@Transactional
	public PhoneBook update(PhoneBook dto, Long id) {
		PhoneBook p = phoneBookRepository.findById(id)

				.orElseThrow(() -> new RuntimeException("Can't find Name"));
		PhoneBook newp = null;
		
		p=dto;
		{
			newp = phoneBookRepository.save(p);
		}
		
		return newp;

	}
	

	@Override
	public PhoneBook delete(Long id) {
		PhoneBook p = phoneBookRepository.findById( id)
				.orElseThrow(() -> new RuntimeException("Can't find Name"));
		phoneBookRepository.delete(p);
		return p;

	}

}

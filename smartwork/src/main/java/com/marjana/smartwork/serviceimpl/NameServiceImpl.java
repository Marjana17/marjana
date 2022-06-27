package com.marjana.smartwork.serviceimpl;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marjana.smartwork.entity.Name;
import com.marjana.smartwork.repository.NameRepository;
import com.marjana.smartwork.service.NameService;

@Service
public class NameServiceImpl implements NameService {
	
	@Autowired
	NameRepository nameRepository;
	

	@Override
	public List<Name> getAllNames() {
		List<Name> n = nameRepository.findAll();
		return n;
	}

	
	@Override
	public Name findById(Long id) {
		Name na = nameRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find Name"));
		return na;
	}
	

	@Override
	@Transactional
	public Name  save(Name dto) {
		Name nam = nameRepository.save(dto);
		return nam;

	}

	
	@Override
	@Transactional
	public Name update(Name n, Long id) {
		Name name = nameRepository.findById(id)

				.orElseThrow(() -> new RuntimeException("Can't find Name"));
		Name newn = null;
		
		name=n;
		{
			newn = nameRepository.save(name);
		}
		
		return newn;

	}
	

	@Override
	public Name delete(Long id) {
		Name named = nameRepository.findById( id)
				.orElseThrow(() -> new RuntimeException("Can't find Name"));
		nameRepository.delete(named);
		return named;

	}

}
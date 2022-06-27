package com.marjana.smartwork.service;

import java.util.List;

import com.marjana.smartwork.entity.Name;

public interface NameService {
List<Name> getAllNames();
	
	Name findById(Long id);
	Name save(Name dto);
	Name update(Name dto, Long id);
	Name delete(Long id);


}

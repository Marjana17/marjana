package com.marjana.smartwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marjana.smartwork.entity.PhoneBook;

public interface PhoneBookRepository extends JpaRepository<PhoneBook,Long> {

}

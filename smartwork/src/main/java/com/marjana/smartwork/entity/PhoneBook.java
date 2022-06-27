package com.marjana.smartwork.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.marjana.smartwork.enums.TypeEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "phonebook")
public class PhoneBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_phone_book")
	private Long idPhoneBook;
	
	@Column(name = "number")
	private Long number;
	
	@Column(name = "type")
	private TypeEnum type;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_name")
	private Name name;
	
}

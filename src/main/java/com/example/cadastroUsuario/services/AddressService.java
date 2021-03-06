package com.example.cadastroUsuario.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.cadastroUsuario.entities.Address;
import com.example.cadastroUsuario.entities.User;
import com.example.cadastroUsuario.repositories.AddressRepository;
import com.example.cadastroUsuario.services.Exception.ResourceNotFoundException;

@Service
public class AddressService {
	
	@Autowired
	private  AddressRepository repository;
	
	public List<Address> findAll(){
		return repository.findAll();
	}
	
	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Address insert(@Valid Address obj) {
		return repository.save(obj);
	}
}

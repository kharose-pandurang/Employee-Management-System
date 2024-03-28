package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Data;
import com.example.demo.repo.DataRepo;

@Service
public class DataService {
	
	@Autowired
	DataRepo repo;
	
	public void add(Data data)
	{
		repo.save(data);
	}
	
	public List<Data> getAll()
	{
		 return repo.findAll();
	}
	
	public Data fingById(int id)
	{
		Optional<Data> optional=repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public void update(Data data)
	{
		repo.save(data);
	}
	
	public void delete(int id)
	{
		  repo.deleteById(id);
	}

}

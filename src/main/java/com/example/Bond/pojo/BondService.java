package com.example.Bond.pojo;



import java.util.List;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BondService {

	
	@Autowired
	private BondRepository bondrep;
	
	private List<Bondd> bonds = Arrays.asList(	
	new Bondd("daniel", "Audi", 6),  new Bondd("sean", "mercedes", 2),  new Bondd("roger", "bmw", 3)
	);
	
	
	/*
	public List<Bondd> getAllBondsAA()
	{
		return bondrep.findAll();
	}
*/
	
	public List<Bondd> getAllBonds()
	{
		return bonds;
	}
	
	public Bondd getBond(String name)
	{
		return bonds.stream().filter(t-> t.getName().equals(name)).findFirst().get();
	}
}

package it.sysman.progettoristoranti.dao;

import java.util.List;

import it.sysman.progettoristoranti.Model.Address;

public interface AddressDao {

	public List<Address>findAll();
	public Address findByID();
	public void deleteByID();
	public void deleteAll();
	public boolean save(Address addr);
	public boolean update();
	
}

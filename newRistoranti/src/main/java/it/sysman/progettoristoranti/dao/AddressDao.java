package it.sysman.progettoristoranti.dao;

import java.util.List;

import it.sysman.progettoristoranti.DTO.AddressDTO;
import it.sysman.progettoristoranti.Model.Address;

public interface AddressDao {

	public List<Address>findAll();
	public Address findByID(int id);
	public void deleteByID(int id);
	public void deleteAll();
	public boolean save(Address addr);
	public List<Address> search(Address a, String operator);
}

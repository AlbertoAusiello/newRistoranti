package it.sysman.progettoristoranti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.sysman.progettoristoranti.Model.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AddressDaoImpl implements AddressDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address findByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean save(Address addr) {
		Address a= entityManager.merge(addr);
		if(a!=null) return true;
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

}

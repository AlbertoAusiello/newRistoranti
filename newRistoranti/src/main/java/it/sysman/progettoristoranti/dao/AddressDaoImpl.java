package it.sysman.progettoristoranti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.sysman.progettoristoranti.Model.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Address> findAll() {
		Query theQuery = entityManager.createNativeQuery("select * from address",Address.class);
		if(!theQuery.getResultList().isEmpty()) {
			List<Address> a= theQuery.getResultList();
			return a;
		}
		return null;
	}

	@Override
	public Address findByID(int id) {
		Address a= entityManager.find(Address.class, id);
		if(a!=null) return a;
		return null;
	}

	@Override
	public void deleteByID(int id) {
		Address a= entityManager.find(Address.class, id);
		entityManager.remove(a);
		
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

}

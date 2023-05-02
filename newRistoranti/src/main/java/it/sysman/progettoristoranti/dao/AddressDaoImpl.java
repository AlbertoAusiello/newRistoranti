package it.sysman.progettoristoranti.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.sysman.progettoristoranti.DTO.AddressDTO;
import it.sysman.progettoristoranti.Model.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

	
	public List<Address> search(Address a, String operator) {
		String partialQuery ="select * from address where ";
		List<String> values = new ArrayList();
		List<String> fields = new ArrayList();
		int operatorNumber=0;
		values.add(a.getAmenity());
		fields.add("amenity");
		values.add(a.getBorough());
		fields.add("borough");
		values.add(a.getCity());
		fields.add("city");
		values.add(a.getHouseNumber());
		fields.add("house_number");
		values.add(a.getNeighbourhood());
		fields.add("neighbourhood");
		values.add(a.getPostcode());
		fields.add("postcode");
		values.add(a.getRoad());
		fields.add("road");
		values.add(a.getSuburb());
		fields.add("suburb");
		
		for(int i=0;i<values.size();i++) {
			if(values.get(i).equalsIgnoreCase("string")) {
				values.remove(i);
				fields.remove(i);
				i=-1;
			}
		}
		operatorNumber= values.size()-1;
		for(int i=0;i<values.size();i++) {
			partialQuery += fields.get(i)+"="+"'"+values.get(i)+"'";
			if(i<operatorNumber)
				partialQuery+=" "+operator+" ";
		}
		
		TypedQuery<Address> theQuery=(TypedQuery<Address>) entityManager.createNativeQuery(partialQuery, Address.class);
		List<Address> addr= theQuery.getResultList();
		
		return addr;
	}

	
}

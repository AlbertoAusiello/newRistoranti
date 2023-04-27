package it.sysman.progettoristoranti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.sysman.progettoristoranti.Model.Country;
import jakarta.persistence.EntityManager;

@Repository
public class CountryDaoImpl implements CountryDao {

	 @Autowired
	private EntityManager entityManager;
	@Override
	public Country save(Country countr) {
		Country a= entityManager.merge(countr);
		if(a!=null) return a;
		return null;
		
	}

}

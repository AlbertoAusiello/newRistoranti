package it.sysman.progettoristoranti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.sysman.progettoristoranti.Model.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	
	
}

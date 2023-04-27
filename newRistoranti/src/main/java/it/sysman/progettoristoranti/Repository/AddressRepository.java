package it.sysman.progettoristoranti.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.sysman.progettoristoranti.Model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query(value="select * from address where address.amenity = ?1", nativeQuery=true)
	public Address findAmenity( String amenity);
	
	@Query(value="select * from address where address.city = ?1", nativeQuery=true)
	public List<Address> findCity( String city);
	
	
}

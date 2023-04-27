package it.sysman.progettoristoranti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.sysman.progettoristoranti.Model.OSMInfo;
@Repository
public interface OSMInfoRepository extends JpaRepository<OSMInfo, Integer>{

	public OSMInfo findByPlaceId(String placeId);
}

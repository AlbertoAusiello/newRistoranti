package it.sysman.progettoristoranti.dao;

import org.springframework.beans.factory.annotation.Autowired;

import it.sysman.progettoristoranti.Model.OSMInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class OSMInfoDaoImpl implements OSMInfoDao{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public OSMInfo findByPlaceId(String placeId) {
		Query theQuery =entityManager.createNativeQuery("SELECT * from osminfo where place_id="+placeId,OSMInfo.class);
		if(!theQuery.getResultList().isEmpty()) return (OSMInfo) theQuery.getSingleResult();
		return null;
	}

}

package it.sysman.progettoristoranti.dao;

import it.sysman.progettoristoranti.Model.OSMInfo;

public interface OSMInfoDao {

	public OSMInfo findByPlaceId(String placeId);
}

 package it.sysman.progettoristoranti.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.sysman.progettoristoranti.ProgettoRistorantiApplication;
import it.sysman.progettoristoranti.DTO.AddressDTO;
import it.sysman.progettoristoranti.DTO.ResturantDTO;
import it.sysman.progettoristoranti.Model.Address;
import it.sysman.progettoristoranti.Model.Coordinate;
import it.sysman.progettoristoranti.Model.Country;
import it.sysman.progettoristoranti.Model.OSMInfo;
import it.sysman.progettoristoranti.dao.AddressDaoImpl;
import it.sysman.progettoristoranti.dao.CountryDaoImpl;
import it.sysman.progettoristoranti.dao.OSMInfoDaoImpl;
import it.sysman.progettoristoranti.tools.JsonConverter;
import jakarta.transaction.Transactional;

@Service
public class ResturantServiceIMPL  implements ResturantService{
	
	private static final Logger LOGGER = LogManager.getLogger(ProgettoRistorantiApplication.class);
	
	@Autowired
	private AddressDaoImpl ar;
	@Autowired
	private CountryDaoImpl cr;
	@Autowired
	private OSMInfoDaoImpl osr;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	public ResturantDTO findAmenity(@RequestParam String amenity) {
//		Address address = ar.findAmenity(amenity);
//		if(!address.equals(null)) {
//			modelMapper.getConfiguration().setAmbiguityIgnored(true);
//			AddressDTO adto = modelMapper.map(address, AddressDTO.class);
//			ResturantDTO rdto = modelMapper.map(address.getOsmId(),ResturantDTO.class);	
//			modelMapper.map(address, rdto);
//			modelMapper.map(address.getCoor(), rdto);
//			rdto.setAddress(adto);
//			return rdto;
//		}
//		return null;
//	}
	
//	public List<ResturantDTO> findCity(@RequestParam String city) {
//		List<Address> a = ar.findCity(city);
//		List<ResturantDTO> rdtlist = new ArrayList();
//		if(!a.equals(null)) {
//			for (Address address : a) {
//				modelMapper.getConfiguration().setAmbiguityIgnored(true);
//				AddressDTO adto = modelMapper.map(address, AddressDTO.class);
//				ResturantDTO rdto = modelMapper.map(address.getOsmId(),ResturantDTO.class);	
//				modelMapper.map(address, rdto);
//				modelMapper.map(address.getCoor(), rdto);
//				rdto.setAddress(adto);
//				rdtlist.add(rdto);
//			}
//			return rdtlist;
//		}
//		return null;
//	}
	
	
	
//	public void deleteAll() {
//		ar.deleteAll();
//		cr.deleteAll();
////		cor.deleteAll();
////		osr.deleteAll();
//	}
	@Transactional
	public void deleteById(int addressId)throws IllegalArgumentException {
		
		ar.deleteByID(addressId);
		
	}
	public ResturantDTO getResturantID(int addressId) {
		Optional<Address> address = Optional.of(ar.findByID(addressId));
		if(address.isPresent()) {
			modelMapper.getConfiguration().setAmbiguityIgnored(true);
			AddressDTO adto = modelMapper.map(address.get(), AddressDTO.class);
			ResturantDTO rdto = modelMapper.map(address.get().getOsmId(),ResturantDTO.class);	
			modelMapper.map(address.get().getCoor(), rdto);
			rdto.setAddress(adto);
			return rdto;
		}else {
			return null;
		}	
	}
	@Transactional
	public String fillDb(){
		ObjectMapper objM = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ResturantDTO [] rest=null;
		try 
		{
			rest = objM.readValue(JsonConverter.toJava(new File("C:\\Users\\sarex\\Desktop\\start_restaurants.json")), ResturantDTO[].class);
		}
		catch (IOException e) {e.printStackTrace();}
		Coordinate cord = null;
		Address addr = null;
		Country countr = null;
		OSMInfo osminfo=null;
		for (ResturantDTO resturantDTO : rest) {
			if(osr.findByPlaceId(resturantDTO.getPlaceId())==null) {
				cord = modelMapper.map(resturantDTO,Coordinate.class);
				addr = modelMapper.map(resturantDTO.getAddress(), Address.class);
				countr = modelMapper.map(resturantDTO.getAddress(), Country.class);
				osminfo=modelMapper.map(resturantDTO, OSMInfo.class);
				addr.setCoor(cord);
				addr.setCountry(cr.save(countr));
				addr.setOsmId(osminfo);
				ar.save(addr);
			}
		}
		return new String ("Caricamento Avvenunto con successo");
	}
	
	public List<ResturantDTO> findAllResturants() {
		List<Address> address = ar.findAll();
		List<ResturantDTO> rdto = new ArrayList();
		ResturantDTO res= new ResturantDTO();
		for (Address add : address) {
			AddressDTO adto= modelMapper.map(add, AddressDTO.class);
			res= modelMapper.map(add.getOsmId(), ResturantDTO.class);
			modelMapper.map(add.getCoor(), res);
			res.setAddress(adto);
			rdto.add(res);
		}
		return rdto;
	}
	
	public ResturantDTO update(int id, ResturantDTO rdt) {
		ResturantDTO rdtTemp= getResturantID(id);
		rdtTemp= modelMapper.map(rdt, ResturantDTO.class);
		Coordinate cord = modelMapper.map(rdtTemp,Coordinate.class);
		Address addr = modelMapper.map(rdtTemp.getAddress(), Address.class);
		Country countr = modelMapper.map(rdtTemp.getAddress(), Country.class);
		OSMInfo osminfo=modelMapper.map(rdtTemp, OSMInfo.class);
		addr.setCoor(cord);
		addr.setCountry(cr.save(countr));
		addr.setOsmId(osminfo);
		addr.setAddressId(id);
		ar.save(addr);
		return rdtTemp;
	}

	@Transactional
	public ResturantDTO insert( ResturantDTO rdt) {
		ResturantDTO rdtTemp= modelMapper.map(rdt, ResturantDTO.class);;
		Coordinate cord = modelMapper.map(rdtTemp,Coordinate.class);
		Address addr = modelMapper.map(rdtTemp.getAddress(), Address.class);
		Country countr = modelMapper.map(rdtTemp.getAddress(), Country.class);
		OSMInfo osminfo=modelMapper.map(rdtTemp, OSMInfo.class);
		addr.setCoor(cord);
		addr.setCountry(cr.save(countr));
		addr.setOsmId(osminfo);
		ar.save(addr);
		return rdtTemp;
	}
}


package it.sysman.progettoristoranti.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class ResturantDTO {

	private String placeId;
	@Column(name="licence")
	private String license;
	private String osmType;
	private String osmId;
	private String lat;
	private String lon;
	private String displayName;
	private String type;
	private String importance;
	private String icon;
	private AddressDTO address;
	//@JsonProperty("country")
//	private CountryDTO country;
//	private String country;
//	private String countryCode;
	
	@Override
	public String toString() {
		return "ResturantDTO [placeId=" + placeId + ", license=" + license + ", osmType=" + osmType + ", osmId=" + osmId
				+ ", lat=" + lat + ", lon=" + lon + ", displayName=" + displayName + ", type=" + type + ", importance="
				+ importance + ", icon=" + icon + ", address=" + address + "]";
	}
	

	
	
	
}

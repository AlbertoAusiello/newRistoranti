package it.sysman.progettoristoranti.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	private String amenity;
	private String houseNumber;
	private String road;
	private String neighbourhood;
	private String suburb;
	private String borough;
	private String city;
	private String postcode;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name="country_id")
	private Country country;
	
	@JsonIgnore
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="osm_id")
	private OSMInfo osmId;
	
	@JsonIgnore
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="coordinate_id")
	private Coordinate coor;
	
	@JsonProperty("ISO3166-2-lvl4")
	@Column(name="ISO3166-2-lvl4")
	private String ISO3166;

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", amenity=" + amenity + ", houseNumber=" + houseNumber + ", road="
				+ road + ", neighbourhood=" + neighbourhood + ", suburb=" + suburb + ", borough=" + borough + ", city="
				+ city + ", postcode=" + postcode + ", country=" + country + ", osmId=" + osmId + ", coor=" + coor
				+ ", ISO3166=" + ISO3166 + "]";
	}

	
}


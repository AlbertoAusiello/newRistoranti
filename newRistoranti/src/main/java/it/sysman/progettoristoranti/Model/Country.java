package it.sysman.progettoristoranti.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int countryId;
	@JsonProperty("country")
	private String country;
	private String countryCode;
	
	@JsonIgnore
	@OneToMany(mappedBy = "country",cascade = {CascadeType.ALL})
	private List<Address> addresses;

	@Override
	public String toString() {
		return "Country [country=" + country + ", countryCode=" + countryCode + ", addresses=" + addresses + "]";
	}

	public Country(String countryJ, String countryCode) {
		super();
		this.country = countryJ;
		this.countryCode = countryCode;
	}

	
	
}

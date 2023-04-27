package it.sysman.progettoristoranti.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;

import it.sysman.progettoristoranti.Model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CountryDTO {

	private String country;
	private String countryCode;
}

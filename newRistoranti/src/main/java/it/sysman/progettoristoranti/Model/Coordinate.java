package it.sysman.progettoristoranti.Model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "coordinate")
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int coordinateId;
	private String lat;
	private String lon;
	
	@Override
	public String toString() {
		return "Coordinate [coordinateId=" + coordinateId + ", lat=" + lat + ", lon=" + lon + 
				 "]";
	}
	
	
	
	
}

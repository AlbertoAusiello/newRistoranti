package it.sysman.progettoristoranti.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
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
@Table(name = "osminfo")
@NoArgsConstructor
@AllArgsConstructor
public class OSMInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int osminfoId;
	@Column(name="place_id")
//	@JsonProperty("place_id")
	private String placeId;
	@Column(name="osm_id")
	private String osmId;
	@Column(name="display_name")
//	@JsonProperty("display_name")
	private String displayName;
	@Column(name="osm_type")
	private String osmType;
	@Column(name="licence")
	private String license;
	private String type;
	private String icon;
	private String importance;
	@Override
	public String toString() {
		return "OSMInfo [placeId=" + placeId + ", osmId=" + osmId + ", displayName=" + displayName + ", osmType="
				+ osmType + ", licence=" + license + ", type=" + type + ", icon=" + icon + ", importance=" + importance
				+ "]";
	}

	
}

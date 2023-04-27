package it.sysman.progettoristoranti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.sysman.progettoristoranti.Model.Coordinate;
@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate,Integer>{

}

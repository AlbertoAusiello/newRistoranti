package it.sysman.progettoristoranti.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import it.sysman.progettoristoranti.DTO.AddressDTO;
import it.sysman.progettoristoranti.DTO.ResturantDTO;
import it.sysman.progettoristoranti.Model.Address;
import it.sysman.progettoristoranti.Service.ResturantServiceIMPL;
import jakarta.annotation.PostConstruct;


@RestController
public class ResturantController {
	
	private static final Logger LOGGER = LogManager.getLogger(ResturantController.class);
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ResturantServiceIMPL service;
	
	@PostConstruct
	public void doAtStart() {
		service.fillDb();
	}

//	@GetMapping("/resturants/findAmenity/{amenity}")
//	public ResponseEntity<ResturantDTO>findAmenity(@PathVariable("amenity") String amenity){
//		try {
//			return new ResponseEntity<ResturantDTO>(service.findAmenity(amenity), HttpStatus.OK); 
//		} catch (Exception e) {
//			LOGGER.error(HttpStatus.BAD_REQUEST ,e.getCause());
//			return new ResponseEntity<ResturantDTO>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	@GetMapping("/resturants/findCity/{city}")
//	public ResponseEntity<List<ResturantDTO>>findCity(@PathVariable("city") String city){
//		try {
//			return new ResponseEntity<List<ResturantDTO>>(service.findCity(city), HttpStatus.OK); 
//		} catch (Exception e) {
//			LOGGER.error(HttpStatus.BAD_REQUEST ,e.getCause());
//			return new ResponseEntity<List<ResturantDTO>>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
	//get resturant byID
	@Operation(summary = "Get a resturant by id",description = "use the address id to return the chosen resturant")
	@GetMapping("/resturants/{id}")
	public ResponseEntity<ResturantDTO> getID(@PathVariable("id") int id){
		try {
			LOGGER.info(HttpStatus.OK+"the chosen resturant exsists");
			return new ResponseEntity<ResturantDTO>(service.getResturantID(id),HttpStatus.OK);
		}catch(Exception e) {
			LOGGER.error(HttpStatus.BAD_REQUEST+"The choosen resturant does not exists");
			return new ResponseEntity<ResturantDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//findALL
	@Operation(summary = "Get All resturants",description = "getting all the resturants from the database")
	@GetMapping("/resturant/findAll")
	public ResponseEntity<List<ResturantDTO>> getAllResturant(){
		try {
			return new ResponseEntity<List<ResturantDTO>>(service.findAllResturants(),HttpStatus.OK) ;			
		} catch (Exception e) {
			LOGGER.error(HttpStatus.BAD_REQUEST +"On FindAll() function");
			return new ResponseEntity<List<ResturantDTO>>(HttpStatus.BAD_REQUEST) ;	
		}
	}

//	
//	//delete ALL
//	@Operation(summary = "Flush the Database",description = "Perform a delete on each table of the database")
//	@DeleteMapping("/resturants/deleteAll")
//	public ResponseEntity delete(){
//		try {
//			service.deleteAll();
//			return new ResponseEntity(HttpStatus.OK);
//		} catch (Exception e) {
//			LOGGER.error(HttpStatus.BAD_REQUEST +"On DeleteAll() function");
//			return new ResponseEntity(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
	//deleteByID
	@Operation(summary = "Delete a single resturant",description = "find a specific resturant by ID and deleting it from the db")
	@DeleteMapping("/resturants/deleteBy/{id}")
	public ResponseEntity deleteId(@PathVariable("id")int id) {
		try {
			service.deleteById(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(HttpStatus.BAD_REQUEST +"On DeleteByID() function, the chosen id does not exists");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	//update Resturant
	@Operation(summary = "Update an exsisting resturant",description = "find a specific resturant by ID and update it passing a different body")
	@PutMapping("/resturants/update/{id}")
	public ResponseEntity<ResturantDTO> update(@PathVariable("id") int id, @RequestBody ResturantDTO rdt) {
		try {
			
			return new ResponseEntity<ResturantDTO>(service.update(id, rdt),HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(HttpStatus.BAD_REQUEST +"On update() function, the chosen id does not exists");
			return new ResponseEntity<ResturantDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	//insert
	@Operation(summary = "Insert a new resturant",description = "Insert a new resturant just using a body, the db will take care of setting the id")
	@PostMapping("/resturants/insert")
	public ResponseEntity<ResturantDTO> insert( @RequestBody ResturantDTO rdt) {
		try {
			return new ResponseEntity<ResturantDTO>(service.insert(rdt),HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(HttpStatus.BAD_REQUEST +"On insert() function, Cannot inserert the given resturant");
			return new ResponseEntity<ResturantDTO>(HttpStatus.CONFLICT);
		}
	}
	@PostMapping("/resturants/search/{operator}")
	public ResponseEntity<List<ResturantDTO>> search(@RequestBody AddressDTO a,@PathVariable String operator){
		try {
			return new ResponseEntity<List<ResturantDTO>>(service.cerca(a,operator),HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(HttpStatus.BAD_REQUEST +"On insert() function, Cannot inserert the given resturant");
			return new ResponseEntity<List<ResturantDTO>>(HttpStatus.CONFLICT);
		}
	}
}

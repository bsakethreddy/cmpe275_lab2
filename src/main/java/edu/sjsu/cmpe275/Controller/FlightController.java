package edu.sjsu.cmpe275.Controller;


import edu.sjsu.cmpe275.Model.Flight;
import edu.sjsu.cmpe275.Model.Plane;
import edu.sjsu.cmpe275.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllPlanes() {
        try {
            List<Flight> flights = new ArrayList<Flight>();

            flightRepository.findAll().forEach(flights::add);
            flights.sort(Comparator.comparing(Flight::getDepartureTime));

            if (flights.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(flights, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

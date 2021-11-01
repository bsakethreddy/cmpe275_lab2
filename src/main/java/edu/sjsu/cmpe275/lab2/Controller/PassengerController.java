package edu.sjsu.cmpe275.lab2.Controller;

import edu.sjsu.cmpe275.lab2.DataSource.PassengerRepository;
import edu.sjsu.cmpe275.lab2.Model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("passenger")
@RestController
public class PassengerController {
    private final PassengerRepository passengerRepository;
    @Autowired
    public PassengerController(@Qualifier("passengerRepository") PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    @GetMapping(path="/{id}")
    public Passenger getPassenger(@PathVariable("id") String id){
        return passengerRepository.getById(Integer.parseInt(id));
    }
}

package edu.sjsu.cmpe275.lab2.Controller;

import edu.sjsu.cmpe275.lab2.DataSource.PassengerRepository;
import edu.sjsu.cmpe275.lab2.Model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("passenger")
@RestController
public class PassengerController {
//    @Autowired
//    PassengerRepository passengerRepository;

//
//    public PassengerController(PassengerRepository passengerRepository) {
//        this.passengerRepository = passengerRepository;
//    }

    @GetMapping(value="/{id}")
    public String getPassenger(@PathVariable("id") String id){
        System.out.println("inside get request");
        return "Hi";
//        return passengerRepository.getById(Integer.parseInt(id));
    }
}

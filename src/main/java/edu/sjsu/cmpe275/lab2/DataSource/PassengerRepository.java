package edu.sjsu.cmpe275.lab2.DataSource;

import edu.sjsu.cmpe275.lab2.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}

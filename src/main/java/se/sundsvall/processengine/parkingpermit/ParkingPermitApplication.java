package se.sundsvall.processengine.parkingpermit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.sundsvall.dept44.ServiceApplication;

@ServiceApplication
public class ParkingPermitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingPermitApplication.class, args);
	}

}

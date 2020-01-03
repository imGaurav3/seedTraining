package hb.demo4;

import hb.demo4.model.HealthInsurance;
import hb.demo4.model.InsuranceDao;
import hb.demo4.model.TermInsurance;
import hb.demo4.model.VehicleInsurance;

public class Main {

	public static void main(String[] args) {
		
		HealthInsurance health = new HealthInsurance();
		TermInsurance term = new TermInsurance();
		VehicleInsurance vehicle = new VehicleInsurance();
		
		health.setId(1);
		health.setInsured("Ashish");
		health.setSumInsured(100000);
		health.setHealthPlan("Complete");
		
		term.setId(2);
		term.setInsured("Rahul");
		term.setSumInsured(200000);
		term.setYears(5);
		
		vehicle.setId(3);
		vehicle.setInsured("Danish");
		vehicle.setSumInsured(50000);
		vehicle.setVehicle("Bike");
		
		InsuranceDao dao = new InsuranceDao();
		
		System.out.println("Creating table for Health Insurance...");
		InsuranceDao.create(health);
		
		System.out.println("Creating table for Term Insurance...");
		InsuranceDao.create(term);
		
		System.out.println("Creating table for Vehicle Insurance...");
		InsuranceDao.create(vehicle);
		
		InsuranceDao.shutdown();
	}

}

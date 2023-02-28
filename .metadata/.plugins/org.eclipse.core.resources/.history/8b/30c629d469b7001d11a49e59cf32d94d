package model.services;

import java.time.Duration;

import class_224_interface_car_rental.entities.CarRental;
import class_224_interface_car_rental.entities.Invoice;

public class BrazilRentalServices {

	private Double pricePerHour;
	private double pricePerDay;
	
	private BrazilTaxService taxService;

	public BrazilRentalServices(Double pricePerHour, double pricePerDay, BrazilTaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60;
		double days = hours / 24;
		double basicPayment;
		if( hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours);
		}else {
			basicPayment = pricePerDay * Math.ceil(days);
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
}

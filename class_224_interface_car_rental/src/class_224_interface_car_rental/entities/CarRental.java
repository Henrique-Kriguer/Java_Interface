package class_224_interface_car_rental.entities;

import java.time.LocalDateTime;

public class CarRental {
	
	private LocalDateTime start;
	private LocalDateTime finish;
	private	Vehicle model;
	private Invoice invoice;
	
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public CarRental () {
		
	}
	
	public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle model) {
		this.start = start;
		this.finish = finish;
		this.model = model;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getFinish() {
		return finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return model;
	}

	public void setVehicle(Vehicle vehicle) {
		this.model = vehicle;
	}
	

}

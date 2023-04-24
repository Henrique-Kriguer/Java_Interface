package class_224_interface_car_rental.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import class_224_interface_car_rental.entities.CarRental;
import class_224_interface_car_rental.entities.Vehicle;
import model.services.RentalServices;
import model.services.TaxService;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do Carro: ");
		String model = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:mm)" );
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
		System.out.print("Retorno (dd/MM/yyyy hh:mm)" );
		LocalDateTime finish = LocalDateTime.parse( sc.nextLine(),fmt);	
		
		CarRental cr = new CarRental(start, finish, new Vehicle( model));
		
		System.out.print("Entre com o preço por hora: ");
		Double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		Double pricePerDay = sc.nextDouble();
		
		RentalServices rentalService = new RentalServices(pricePerHour, pricePerDay, new TaxService());
		rentalService.processInvoice(cr);
		
		System.out.println("Fatura: ");
		System.out.println("Pagamento básico: " +String.format("%.2f, cr.getInvoice().getBasicPayment()"));
		System.out.println("Imposto: "+ String.format("%.2f, cr.getInvoice().getTax())"));
		System.out.println("Pagamento Total : "+String.format("%.2f, cr.getInvoice().getTotalPayment())"));
		
		sc.close();
	}

}

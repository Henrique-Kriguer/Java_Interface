package class_224_interface_car_rental.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import class_224_interface_car_rental.entities.CarRental;
import class_224_interface_car_rental.entities.Vehicle;
import model.services.BrazilRentalServices;
import model.services.BrazilTaxService;

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
		
		CarRental rental = new CarRental(start, finish, new Vehicle( model));
		
		System.out.print("Entre com o preço por hora: ");
		Double pricePerHour = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		Double pricePerDay = sc.nextDouble();
		
		BrazilRentalServices brasilRentalServices = new BrazilRentalServices(pricePerHour, pricePerDay, new BrazilTaxService());
		brasilRentalServices.processInvoice(rental);
		
		System.out.println("Fatura: ");
		System.out.println("Pagamento básico: " + rental.getInvoice().getBasicPayment());
		System.out.println("Impoto: "+ rental.getInvoice().getTax());
		System.out.println("Pagamento Total : "+ rental.getInvoice().getTotalPayment());
		
		sc.close();
	}

}

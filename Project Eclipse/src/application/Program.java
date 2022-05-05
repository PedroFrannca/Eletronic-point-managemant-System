package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entities.Departament;
import Entities.HourContract;
import Entities.Worker;
import Entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter departament's name:");
		String departamentName = sc.nextLine();
		System.out.println("Enter Worker data:");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.print("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value Per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.print("\n\nEnter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: "+ worker.getName());
		System.out.println("Departament: "+ worker.getDepartament());
		System.out.println("Income for "+ monthAndYear + ": " + worker.inCome(year, month));
		
		sc.close();
		
	}

}

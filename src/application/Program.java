package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.EmployeeData;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//instançiando a lista
		List<EmployeeData> employees = new ArrayList<>();

		int N = Integer.parseInt(JOptionPane.showInputDialog("How many employees wil be registred? "));

		for (int i = 0; i < N; i++) {

			System.out.println("Employee #" + (i + 1));
			int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
			String name = JOptionPane.showInputDialog("Name: ");
			double salary = Double.parseDouble(JOptionPane.showInputDialog("Salary: "));
			//adicionando a lista
			employees.add(new EmployeeData(id, name, salary));

		}

		System.out.println("List of employees: ");

		//mostrando a lista
		for (EmployeeData employeeData : employees) {

			System.out.println(employeeData);

		}

		System.out.println("---------------- UPDATED ------------------------");
		
		//instançiando uma nova lista na qual sera salvo somente o funcionario com o ID correspondente
		List<EmployeeData> employeesId = new ArrayList<>();

		//pedindo o ID do funcionario
		int findById = Integer.parseInt(JOptionPane.showInputDialog("Enter the employee id that will have salary increase: "));

		//rodando a 1a lista 
		for (EmployeeData employeeData : employees) {
            
			//procurando ID correspondente e salvando na 2a lista employeesId
			employeesId.add(employees.stream().filter(x -> x.getId() == findById).findFirst().orElse(null));

		}

		//verificando se a lista esta vazia
		if (employeesId != null) {

			double percent = Double.parseDouble(JOptionPane.showInputDialog("Enter the percetage: "));
			for (EmployeeData employeeData : employeesId) {

				//passando a porcentagem como argumento para o metodo
				employeeData.increaseSalary(percent);
				System.out.println(employeeData);
			}

		}

		for (EmployeeData employeeData : employeesId) {
			System.out.println(employeeData);
		}
	}

}

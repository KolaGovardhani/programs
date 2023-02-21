package modulepackage;

import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		EmployeeInterface einterface=new EmployeeInterfaceImpl();
		char ch=' ';
		do {
		System.out.println("1---addEmployee \n 2---updateEmployee \n 3--deleteEmployee\n 4--viewDetails \n 5-exit");
		System.out.println("enter the option");
		Scanner scanner = new Scanner(System.in);
		int option =scanner.nextInt();
		switch(option)
		{
		case 1: System.out.println("enter the employee details Eid Ename Esalary");
		int Eid=scanner.nextInt();
		String Ename=scanner.next();
		float Esalary=scanner.nextFloat();
		Employee employee = new Employee(Eid,Ename,Esalary);
			try {
				einterface.addEmployee(employee);
			} catch (SQLException e) {
				System.out.println("adding employee -->"+e.getMessage());
			}
			break;
		case 2:
			System.out.println("enter the Employee Eid to modify");
			int Eid1=scanner.nextInt();
			System.out.println("enter the property you want to change");
			String property=scanner.next();
			Employee employee1 = new Employee();
			if(property.equals("name")) {
				System.out.println("enter the new Ename");
				employee1.setEname(scanner.next());
			}
			if(property.equals("salary"))
			{
				System.out.println("enter the new Esalary");
				employee1.setEsalary(scanner.nextFloat());
			}
			try {
				int r=einterface.updateEmployee(employee1, Eid1,property);
			if(r==1)
				System.out.println("Updated successfuly");
			} catch (SQLException e) {
				System.out.println("update employee -->"+e.getMessage());
			}
			break;
		case 3: 
			System.out.println("Enter the Eid to delete ");
			 int Eid11=scanner.nextInt();
				try {
					einterface.deleteEmployee(Eid11);
				} catch (SQLException e) {
					System.out.println("deleting Eid -->"+e.getMessage());
				}
			System.out.println("Deleted Successfully");
			break;
		case 4:
			try {
				einterface.displayEmployeeDetails();
			} catch (SQLException e) {
				System.out.println("adding employe -->"+e.getMessage());
			}
			break;
		case 5: 
			System.out.println("Exited Successfully");
			break;
			default: System.out.println("enter the valid option");
			break;
		}
		System.out.println("do you wish to continue say yes");
		ch=scanner.next().charAt(0);
		}while(ch=='y' || ch=='Y');
	}


}

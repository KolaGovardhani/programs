package modulepackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeInterfaceImpl implements EmployeeInterface{

	Connection connection=null;
	PreparedStatement pstatement=null;
	public EmployeeInterfaceImpl()
	{
		connection=CustomConnection.getCustConnection();
	}
	public void addEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub

		pstatement=connection.prepareStatement("insert into Employee values(?,?,?)");
		pstatement.setInt(1, employee.getEid());
		pstatement.setString(2, employee.getEname());
		pstatement.setFloat(3,employee.getEsalary());
		int res=pstatement.executeUpdate();
		if(res==1)
		{
			System.out.println("inserted successfully");
		}
	}
		
	

	public int updateEmployee(Employee employee, int Eid, String property) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee1=findEmployeeById(Eid);
		if(property.equals("name"))
			employee1.setEname(employee.getEname());
		if(property.equals("salary"))
			employee1.setEsalary(employee.getEsalary());
		
			pstatement=connection.prepareStatement("update employee set Ename=?,Esalary=? where Eid=? ");
			pstatement.setString(1,employee1.getEname());
			pstatement.setFloat(2, employee1.getEsalary());
			pstatement.setInt(3, Eid);
			int r=pstatement.executeUpdate();
			return r;
		}
	public Employee findEmployeeById(int Eid) throws SQLException {
		// TODO Auto-generated method stub
		pstatement=connection.prepareStatement("select *from employee where Eid=?");
		pstatement.setInt(1,Eid);
		ResultSet rs=pstatement.executeQuery();
		rs.next();
		Employee employee=new Employee(rs.getInt(1),rs.getString(2),rs.getFloat(3));
		return employee;
	}
		

	public void displayEmployeeDetails() throws SQLException {
		// TODO Auto-generated method stub
		pstatement=connection.prepareStatement("select *from employee");
		ResultSet resultSet = pstatement.executeQuery();
	while(resultSet.next())//next() --brings the cursor to the first record
		//returns true
	{
	int Eid=resultSet.getInt("Eid");
	String Ename=resultSet.getString("Ename");
	float Esalary=resultSet.getFloat("Esalary");
	Employee employee = new Employee(Eid,Ename,Esalary);
	System.out.println(employee);
	}
	}
	public int deleteEmployee(int Eid) throws SQLException {
		pstatement = connection.prepareStatement("delete from employee where Eid=?");
		pstatement.setInt(1,Eid);
		int del=pstatement.executeUpdate();
		System.out.println("deleted Id:"+del);
		return del;
	}
		
	}



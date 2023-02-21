package modulepackage;

import java.sql.SQLException;

public interface EmployeeInterface {
	void addEmployee(Employee employee) throws SQLException;
	int updateEmployee(Employee employee , int Eid,String property) throws SQLException;
	int deleteEmployee(int Eid) throws SQLException;
	Employee findEmployeeById(int Eid) throws SQLException;
	void displayEmployeeDetails() throws SQLException;
}

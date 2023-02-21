package modulepackage;

public class Employee {
	private int Eid;
	private String Ename;
	private float Esalary;

	public Employee() {
		
	}

	public Employee(int Eid, String Ename, float Esalary) {
		super();
		this.Eid = Eid;
		this.Ename = Ename;
		this.Esalary = Esalary;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int Eid) {
		this.Eid = Eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String Ename) {
		this.Ename = Ename;
	}
	public float getEsalary() {
		return Esalary;
	}
	public void setEsalary(float Esalary) {
		this.Esalary = Esalary;
	}
	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", Ename=" + Ename + ", Esalary=" + Esalary + "]";
	}


}

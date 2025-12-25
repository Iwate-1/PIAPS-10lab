import java.util.ArrayList;
import java.util.List;

public class Institute {
	private String name;
	private String address;
	private List<Faculty> faculties;
	private ResearchAssociate[] employees;
	private int employeeCount;

	public Institute(String name, String address) {
		this.name = name;
		this.address = address;
		this.faculties = new ArrayList<>();
		this.employees = new ResearchAssociate[50]; // Максимум 50 сотрудников
		this.employeeCount = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void addFaculty(Faculty faculty) {
		faculties.add(faculty);
		System.out.println("Факультет '" + faculty.getName() + "' добавлен в институт");
	}

	public void removeFaculty(Faculty faculty) {
		if (faculties.remove(faculty)) {
			System.out.println("Факультет '" + faculty.getName() + "' удален");
		}
	}

	public void addEmployee(ResearchAssociate employee) {
		if (employeeCount < employees.length) {
			employees[employeeCount] = employee;
			employeeCount++;
			System.out.println("Сотрудник '" + employee.getName() + "' добавлен в институт");
		}
	}

	public Faculty[] getFaculties() {
		return faculties.toArray(new Faculty[0]);
	}

	public ResearchAssociate[] getEmployees() {
		ResearchAssociate[] result = new ResearchAssociate[employeeCount];
		System.arraycopy(employees, 0, result, 0, employeeCount);
		return result;
	}
}
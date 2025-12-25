import java.util.ArrayList;
import java.util.List;

public class Faculty {
	private String name;
	private List<Employee> employees;

	public Faculty(String name) {
		this.name = name;
		this.employees = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
		System.out.println("Сотрудник '" + employee.getName() + "' добавлен на факультет '" + name + "'");
	}

	public void removeEmployee(Employee employee) {
		if (employees.remove(employee)) {
			System.out.println("Сотрудник '" + employee.getName() + "' удален с факультета");
		}
	}

	public Employee[] getEmployees() {
		return employees.toArray(new Employee[0]);
	}

	public int getEmployeeCount() {
		return employees.size();
	}
}
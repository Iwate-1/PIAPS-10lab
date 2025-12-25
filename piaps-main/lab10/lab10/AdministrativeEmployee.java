public class AdministrativeEmployee extends Employee {

	public AdministrativeEmployee(int id, String name) {
		super(id, name);
		setPosition("Административный сотрудник");
	}

	public void doAdministrativeWork() {
		System.out.println(getName() + " выполняет административную работу");
	}

	@Override
	public void performWork() {
		doAdministrativeWork();
	}
}
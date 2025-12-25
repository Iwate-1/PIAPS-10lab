public class ResearchAssociate extends Employee {
	private String fieldOfStudy;
	private Project[] projects;

	public ResearchAssociate(int id, String name, String fieldOfStudy) {
		super(id, name);
		this.fieldOfStudy = fieldOfStudy;
		this.projects = new Project[10]; // Максимум 10 проектов
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public void doResearch() {
		System.out.println(getName() + " проводит исследование в области " + fieldOfStudy);
	}

	public void findEmployeesForProject() {
		System.out.println("Поиск сотрудников для проекта...");
	}

	@Override
	public void performWork() {
		doResearch();
	}
}
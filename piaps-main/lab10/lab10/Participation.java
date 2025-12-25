public class Participation {
	private int hours;
	private ResearchAssociate employee;
	private Project project;

	public Participation(ResearchAssociate employee, Project project, int hours) {
		this.employee = employee;
		this.project = project;
		this.hours = hours;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public ResearchAssociate getEmployee() {
		return employee;
	}

	public Project getProject() {
		return project;
	}

	public void displayParticipation() {
		System.out.println(employee.getName() + " участвует в проекте '" +
				project.getName() + "' (" + hours + " часов)");
	}
}
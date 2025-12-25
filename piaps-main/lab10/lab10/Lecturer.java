public class Lecturer extends ResearchAssociate {
	private Course course;

	public Lecturer(int id, String name, String fieldOfStudy) {
		super(id, name, fieldOfStudy);
	}

	public void teach(Course course) {
		this.course = course;
		System.out.println(getName() + " преподает курс: " + course.getName());
	}

	public void getMark(int studentId) {
		System.out.println("Оценка для студента ID: " + studentId);
	}

	public void makeStudyPlan() {
		System.out.println("Создание учебного плана...");
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public void performWork() {
		if (course != null) {
			teach(course);
		}
		doResearch();
	}
}
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        new UniversityApp().runDiagnostics();
    }
}

class UniversityApp {
    private Institute vsu;
    private List<Employee> staff;
    private Project currentProject;
    private Participation entry;

    public void runDiagnostics() {
        setupInfrastructure();
        hireStaff();
        mapStaffToDepartments();
        configureAcademicProcess();
        initiateResearch();
        printReport();
        finalizeRestructuring();
    }

    private void setupInfrastructure() {
        // Создаем базовый объект института
        vsu = new Institute("Воронежский Государственный Университет", "Университетская площадь, 1");

        // Используем потоковую передачу для добавления факультетов
        Stream.of("Факультет Компьютерных Наук", "Физический Факультет")
                .map(Faculty::new)
                .forEach(vsu::addFaculty);
    }

    private void hireStaff() {
        // Инициализация списка сотрудников через ArrayList
        staff = new ArrayList<>();
        staff.add(new ResearchAssociate(1001, "Егоров Егор Сергеевич", "Искусственный интеллект"));
        staff.add(new Lecturer(1002, "Петров Петр Иванович", "Системное программирование"));
        staff.add(new AdministrativeEmployee(1003, "Иванов Иван Михайлович"));
    }

    private void mapStaffToDepartments() {
        // Работаем с первым факультетом в списке
        Faculty csDept = vsu.getFaculties()[0];
        for (Employee member : staff) {
            csDept.addEmployee(member);
        }
        System.out.println("✓ Сотрудники распределены на факультет: " + csDept.getName());

        // Регистрация исследователей в институте
        staff.stream()
                .filter(ResearchAssociate.class::isInstance)
                .map(ResearchAssociate.class::cast)
                .forEach(vsu::addEmployee);
    }

    private void configureAcademicProcess() {
        // Поиск преподавателя через фильтрацию
        staff.stream()
                .filter(e -> e instanceof Lecturer)
                .findFirst()
                .ifPresent(e -> {
                    Lecturer l = (Lecturer) e;
                    l.setCourse(new Course(501, "Современные технологии программирования на Java", 90.0f));
                    System.out.println("✓ Учебный курс назначен преподавателю");
                });
    }

    private void initiateResearch() {
        // Логика работы с датами и проектом
        Employee lead = staff.get(0);
        if (lead instanceof ResearchAssociate) {
            ResearchAssociate ra = (ResearchAssociate) lead;
            ra.setFieldOfStudy("Глубинное машинное обучение");

            long now = System.currentTimeMillis();
            long halfYearMillis = 180L * 24 * 60 * 60 * 1000;

            currentProject = new Project(
                    "Инновационные исследования в области нейросетевых технологий",
                    new Date(now),
                    new Date(now + halfYearMillis)
            );

            entry = new Participation(ra, currentProject, 150);
        }
    }

    private void printReport() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ДЕМОНСТРАЦИЯ РАБОТЫ УНИВЕРСИТЕТСКОЙ СИСТЕМЫ");
        System.out.println("=".repeat(50));

        System.out.println("\n--- Профессиональная деятельность сотрудников ---");
        staff.forEach(Employee::performWork);

        System.out.println("\n--- Детали научно-исследовательского проекта ---");
        if (currentProject != null) currentProject.getProjectInfo();

        System.out.println("\n--- Учёт участия в исследовательских проектах ---");
        if (entry != null) entry.displayParticipation();

        System.out.println("\n--- Организационная структура института ---");
        System.out.printf("Наименование: %s%n", vsu.getName());
        System.out.printf("Местоположение: %s%n", vsu.getAddress());
        System.out.printf("Количество структурных подразделений: %d%n", vsu.getFaculties().length);
    }

    private void finalizeRestructuring() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("Процедура реорганизации структуры института");
        System.out.println("-".repeat(40));

        // Удаляем второй факультет
        Faculty target = vsu.getFaculties()[1];
        vsu.removeFaculty(target);
        System.out.println("✓ Операция завершена");
    }
}
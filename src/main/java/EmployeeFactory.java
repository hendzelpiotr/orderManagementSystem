import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class EmployeeFactory {

    private static final Set<Employee> cache = new HashSet<>();

    public static Employee getEmployee(String firstName, String lastName) {
        final Optional<Employee> optionalEmployee = getFromCache(firstName, lastName);

        final Employee employee = optionalEmployee.orElse(new Employee(firstName, lastName));
        cache.add(employee);

        return employee;
    }

    public static void printCache() {
        System.out.println("Employees in cache are:");
        cache.forEach(employee -> System.out.println(employee.getName()));
    }

    private static Optional<Employee> getFromCache(String firstName, String lastName) {
        return cache
                .stream()
                .filter(employee -> employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName))
                .findFirst();
    }

}

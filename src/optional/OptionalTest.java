package optional;

import stream.Employee;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ClassName OptionalTest
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/8 9:20
 * @Version 1.0
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Employee> employee = Optional.ofNullable(new Employee("AAA", 18, 4567, Employee.Status.BUSY));
        Employee employee1 = employee.orElse(new Employee("AAA", 18, 4567, Employee.Status.BUSY));
        Employee employee2 = employee.orElseGet( () -> new Employee());
        Optional<String> name = employee.map(e -> e.getName());
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(name.get());
    }
}

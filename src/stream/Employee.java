package stream;

import java.util.Objects;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/31 22:54
 * @Version 1.0
 */
public class Employee {
    public String name;
    public int age;
    public double salare;
    public Status status;


    public Employee(String name, int age, double salare, Status status) {
        this.name = name;
        this.age = age;
        this.salare = salare;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalare() {
        return salare;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setSalare(double salare) {
        this.salare = salare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salare, salare) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salare);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salare=" + salare +
                ", status=" + status +
                '}';
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}

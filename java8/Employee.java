package java8;

import java.util.Objects;

public class Employee{
    public String name;
    public int salary;
    public String location;

    public Employee(String name,int salary,String locaton){
    this.name=name;
    this.salary=salary;
    this.location=locaton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Employee e = (Employee) obj;

        return salary == e.salary &&
                Objects.equals(name, e.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
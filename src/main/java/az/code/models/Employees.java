package az.code.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employees")
@Data
@Builder
@NoArgsConstructor
//@AllArgsConstructor
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private LocalDateTime hire_date;

    @ManyToOne
    Jobs job;
    private double salary;

    @ManyToOne
    Employees manager;
    @OneToMany(mappedBy = "manager") //self related table
    List<Employees> employeesList = new ArrayList<>();

    @ManyToOne
    Departments department;

    @Override
    public String toString() {
        return "Employees{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", hire_date=" + getHire_date().toString() +
                ", job=" + job +
                ", salary=" + salary +
                ", manager=" + manager +
                ", employeesList=" + employeesList +
                ", department=" + department +
                '}';
    }

    public Employees(int employee_id, String first_name,
                     String last_name, String email, String phone_number,
                     LocalDateTime hire_date, Jobs job, double salary,
                     Employees manager, List<Employees> employeesList,
                     Departments department) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job = job;
        this.salary = salary;
        this.manager = manager;
        this.employeesList = employeesList;
        this.department = department;
    }
}

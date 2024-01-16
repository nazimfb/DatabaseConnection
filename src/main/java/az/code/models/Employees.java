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
@AllArgsConstructor
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
}

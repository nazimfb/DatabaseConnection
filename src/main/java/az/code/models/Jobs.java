package az.code.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;
    private String jobTitle;
    private double minSalary;
    private double maxSalary;

    @OneToMany(mappedBy = "job")
    List<JobHistory> jobHistory = new ArrayList<>();

    @OneToMany(mappedBy = "job")
    List<Employees> employeesList = new ArrayList<>();
}

package az.code.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobHistoryId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    Jobs job;

    @ManyToOne
    Departments department;
}

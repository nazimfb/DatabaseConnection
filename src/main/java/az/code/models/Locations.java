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
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long location_id;
    private String street_address;
    private int postal_code;
    private String city;
    private String state_province;

    @ManyToOne
    Countries country;

    @OneToMany(mappedBy = "location")
    List<Departments> departmentsList = new ArrayList<>();
}

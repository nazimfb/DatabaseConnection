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
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long region_id;
    private String region_name;

    @OneToMany(mappedBy = "region")
    List<Countries> countriesList = new ArrayList<>();
}

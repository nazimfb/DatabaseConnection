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
@Table(name = "Countries")
@NoArgsConstructor
@AllArgsConstructor
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long country_id;

    @Column(name = "Country Name")
    private String country_name;

    @ManyToOne
    Regions region;

    @OneToMany(mappedBy = "country")
    List<Locations> locationsList = new ArrayList<>();
}

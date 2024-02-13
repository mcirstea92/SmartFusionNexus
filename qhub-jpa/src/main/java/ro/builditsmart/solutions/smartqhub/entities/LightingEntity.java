package ro.builditsmart.solutions.smartqhub.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.builditsmart.solutions.smartqhub.models.lighting.LightState;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lighting")
@Cacheable
@NoArgsConstructor
public class LightingEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20, nullable = false)
    private String name;

    @Column(length = 2, nullable = false)
    private Short raspberryPin;

    @Column(length = 2, nullable = false)
    private Short bcmPin;

    @Column(length = 2, nullable = false)
    private Short wiringPiPin;

    @Column(length = 2, nullable = false)
    private Short ranking;

    @Column(length = 7, nullable = false)
    private String wireHexColor;

    @Column(length = 70)
    private String description;

    private LightState state;

    private List<String> aliases;

    private Long lastUpdated;

    @Column(length = 30)
    private String lastUpdatedBy;

}

package bd.c9.models.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "city")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private FederalUnit federalUnit;
}


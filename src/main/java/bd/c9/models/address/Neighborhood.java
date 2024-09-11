package bd.c9.models.address;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "neighborhood")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Neighborhood {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
}

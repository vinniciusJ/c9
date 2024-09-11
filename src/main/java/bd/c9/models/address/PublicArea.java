package bd.c9.models.address;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "public_area")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class PublicArea {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private PublicAreaType publicAreaType;
}
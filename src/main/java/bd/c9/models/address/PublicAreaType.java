package bd.c9.models.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "public_area_type")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class PublicAreaType {
    @Id
    private String acronym;

    private String name;
}

package bd.c9.models.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "federal_unit")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FederalUnit {
    @Id
    private String acronym;

    private String name;
}

package bd.c9.models.phone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ddi")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class DDI {
    @Id
    private Integer number;
}

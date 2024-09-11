package bd.c9.models.phone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ddd")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class DDD {
    @Id
    private Integer number;
}

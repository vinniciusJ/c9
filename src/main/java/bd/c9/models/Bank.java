package bd.c9.models;

import bd.c9.models.phone.Phone;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bank")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

package bd.c9.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_type")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}

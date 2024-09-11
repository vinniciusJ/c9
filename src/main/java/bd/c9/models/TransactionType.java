package bd.c9.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transaction_type")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private PaymentMethod paymentMethod;
}

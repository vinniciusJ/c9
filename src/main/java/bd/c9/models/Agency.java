package bd.c9.models;

import bd.c9.models.address.Address;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "agency")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Agency {
    @Id
    private String agencyNumber;

    private String name;

    private String addressNumber;

    private String addressComplement;

    @OneToOne
    private Address address;

    @ManyToOne
    private Bank bank;
}

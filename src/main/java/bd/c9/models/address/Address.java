package bd.c9.models.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String zipCode;

    @ManyToOne
    private Neighborhood neighborhood;

    @ManyToOne
    private PublicArea publicArea;

    @ManyToOne
    private City city;

    @Override
    public String toString() {
        return String.format("%s - %s, %s - %s, %s", publicArea.getName(), neighborhood.getName(), city.getName(), city.getFederalUnit().getAcronym(), zipCode);
    }

    public String toString(String number, String complement) {
        return String.format(
                "%s, %s, %s - %s, %s - %s, CEP: %s",
                publicArea.getName(),
                number,
                complement,
                neighborhood.getName(),
                city.getName(),
                city.getFederalUnit().getAcronym(),
                zipCode
                );
    }
}

package magazinfinal.bitlab.magazinfinal.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "discriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Discription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameD")
    private String nameD;

    @Column(name = "modelYear")
    private String modelYear;

    @Column(name = "dioganal")
    private String dioganal;

    @Column(name = "display")
    private String display;

    @Column(name = "ram")
    private String ram;

    @Column(name = "memory")
    private String memory;

    @Column(name = "OS")
    private String OS;

    @Column(name = "accumulator")
    private String accumulator;
}

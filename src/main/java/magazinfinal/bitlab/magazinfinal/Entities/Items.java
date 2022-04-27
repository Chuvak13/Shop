package magazinfinal.bitlab.magazinfinal.Entities;

import groovy.lang.Category;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categgory categgory;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String photo;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    private Discription discription;
}

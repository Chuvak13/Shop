package magazinfinal.bitlab.magazinfinal.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brandName")
    private String brandName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Categgory> categgoryList;
}

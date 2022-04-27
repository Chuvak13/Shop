package magazinfinal.bitlab.magazinfinal.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Categgory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "categoryNameRu")
    private String categoryNameRu;

}

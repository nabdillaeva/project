package gadgetarium.models;

import gadgetarium.dto.request.SaveCatalogRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalogs")
@Getter
@Setter
@NoArgsConstructor
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.PERSIST)
    private List<SubCatalog> subCatalogs;

    public Catalog(SaveCatalogRequest newCatalog) {
        this.name = newCatalog.getCatalogName();
        this.subCatalogs = newCatalog.getSubCatalogList()
                .stream()
                .map(SubCatalog::new)
                .toList();
    }
}

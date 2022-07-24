package gadgetarium.models;

import gadgetarium.dto.mapper.CharacterTemplateMapper;
import gadgetarium.dto.request.SaveSubCatalogRequest;
import gadgetarium.dto.request.characteristic.template.CharacterTemplateRequest;
import gadgetarium.dto.response.GetSubCatalogResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subCatalogs")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Catalog catalog;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<CharacterTemplate> characterTemplates;

    @OneToMany(mappedBy = "subCatalog")
    private List<Product> products;

    public SubCatalog(SaveSubCatalogRequest subCatalogRequest) {
        this.name = subCatalogRequest.getSubCatalogName();
        this.catalog = null;

        List<CharacterTemplateRequest> ctr = new ArrayList<>();

        ctr = subCatalogRequest.toCharacterTemplateRequest(ctr);

        this.characterTemplates = ctr.stream().map(CharacterTemplateMapper::mapToCharacterTemplate).toList();

        this.products = new ArrayList<>();
    }


}

package gadgetarium.dto.response;

import gadgetarium.models.SubCatalog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCatalogResponse {

    private Long id;

    private String catalogName;

    private List<GetSubCatalogResponse> subCatalogResponseList;

}

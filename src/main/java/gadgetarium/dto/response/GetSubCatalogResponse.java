package gadgetarium.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetSubCatalogResponse {

    private Long id;

    private String subCatalogName;

}

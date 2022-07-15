package gadgetarium.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SaveCatalogRequest {

    private String catalogName;

    private List<SaveSubCatalogRequest> subCatalogList;
}

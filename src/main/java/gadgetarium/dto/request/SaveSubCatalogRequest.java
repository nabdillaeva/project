package gadgetarium.dto.request;

import gadgetarium.dto.request.characteristic.template.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class SaveSubCatalogRequest {

    private String subCatalogName;

    private List<SimpleCharacterTemplateRequest> simpleCharacterTemplates;

    private List<SaveImagesCharacterTemplateRequest> imageCharacterTemplates;

    private List<SaveTextDropDownCharacterTemplateRequest> textDropDownCharacterTemplates;

    private List<SaveIntDropDownCharacterTemplateRequest> intDropDownCharacterTemplates;

    public List<CharacterTemplateRequest> toCharacterTemplateRequest(List<CharacterTemplateRequest> ctr) {

        if (simpleCharacterTemplates != null && simpleCharacterTemplates.size() != 0) {
            ctr.addAll(simpleCharacterTemplates);
        }
        if (imageCharacterTemplates != null && imageCharacterTemplates.size() != 0) {
            ctr.addAll(imageCharacterTemplates);
        }
        if (textDropDownCharacterTemplates != null && textDropDownCharacterTemplates.size() != 0) {
            ctr.addAll(textDropDownCharacterTemplates);
        }
        if (intDropDownCharacterTemplates != null && intDropDownCharacterTemplates.size() != 0) {
            ctr.addAll(intDropDownCharacterTemplates);
        }
        return ctr;
    }
}

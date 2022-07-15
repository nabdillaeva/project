package gadgetarium.dto.request.characteristic.template;

import gadgetarium.enums.InputType;
import lombok.Data;

@Data
public class SimpleCharacterTemplateRequest implements CharacterTemplateRequest {

    private InputType type;

    private String title;

    private String description;
}

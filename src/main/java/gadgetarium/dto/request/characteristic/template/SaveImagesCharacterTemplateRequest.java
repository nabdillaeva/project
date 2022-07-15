package gadgetarium.dto.request.characteristic.template;

import lombok.Data;

@Data
public class SaveImagesCharacterTemplateRequest extends SimpleCharacterTemplateRequest {

    private int imageCount;
}

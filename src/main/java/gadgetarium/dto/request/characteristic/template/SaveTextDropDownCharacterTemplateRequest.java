package gadgetarium.dto.request.characteristic.template;

import lombok.Data;

import java.util.List;

@Data
public class SaveTextDropDownCharacterTemplateRequest extends SimpleCharacterTemplateRequest {

    private List<String> values;

}

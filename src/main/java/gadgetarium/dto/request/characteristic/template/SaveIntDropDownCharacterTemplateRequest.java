package gadgetarium.dto.request.characteristic.template;

import lombok.Data;

import java.util.List;

@Data
public class SaveIntDropDownCharacterTemplateRequest extends SimpleCharacterTemplateRequest {

    private List<Integer> values;

}

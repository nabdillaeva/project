package gadgetarium.dto.request.characteristic.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaveTextDropDownCharacterRequest extends SaveCharacterRequest{
    private List<String> values;

    public SaveTextDropDownCharacterRequest(Long templateId, List<String> values) {
        super(templateId);
        this.values = values;
    }
}

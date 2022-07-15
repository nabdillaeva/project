package gadgetarium.dto.request.characteristic.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaveIntDropDownCharacterRequest extends SaveCharacterRequest{
    private List<Integer> values;

    public SaveIntDropDownCharacterRequest(Long templateId, List<Integer> values) {
        super(templateId);
        this.values = values;
    }
}

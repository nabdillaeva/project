package gadgetarium.dto.request.characteristic.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveIntegerCharacterRequest extends SaveCharacterRequest {
    private int value;

    public SaveIntegerCharacterRequest(Long templateId, int value) {
        super(templateId);
        this.value = value;
    }
}

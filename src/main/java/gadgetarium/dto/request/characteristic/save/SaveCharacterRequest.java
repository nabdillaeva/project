package gadgetarium.dto.request.characteristic.save;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class SaveCharacterRequest implements CharacterRequest {
    private Long templateId;

}

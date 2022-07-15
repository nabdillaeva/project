package gadgetarium.dto.request.characteristic.save;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SaveDateCharacterRequest extends SaveCharacterRequest{

    private LocalDate date;

    public SaveDateCharacterRequest(Long templateId, LocalDate date) {
        super(templateId);
        this.date = date;
    }
}

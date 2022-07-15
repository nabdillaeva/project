package gadgetarium.dto.mapper;

import gadgetarium.dto.request.characteristic.template.*;
import gadgetarium.enums.InputType;
import gadgetarium.models.CharacterTemplate;


public class CharacterTemplateMapper {

    public static CharacterTemplate mapToCharacterTemplate(CharacterTemplateRequest request) {

        CharacterTemplate ct = new CharacterTemplate();

        InputType type = request.getType();

        switch (type) {
            case TEXT_VALUE, INT_VALUE, DATE, FILE, COLORS -> {
                SimpleCharacterTemplateRequest sctr = (SimpleCharacterTemplateRequest) request;
                ct.setType(type);
                ct.setTitle(sctr.getTitle());
                ct.setPlaceHolder(sctr.getDescription());
                return ct;
            }
            case IMAGES -> {
                SaveImagesCharacterTemplateRequest saveImagesCharacterTemplateRequest = (SaveImagesCharacterTemplateRequest) request;
                ct.setType(type);
                ct.setTitle(saveImagesCharacterTemplateRequest.getTitle());
                ct.setPlaceHolder(saveImagesCharacterTemplateRequest.getDescription());
                ct.setImageCount(saveImagesCharacterTemplateRequest.getImageCount());
                return ct;
            }
            case INT_DROP_DOWN -> {
                SaveIntDropDownCharacterTemplateRequest saveIntDropDownCharacterTemplateRequest = (SaveIntDropDownCharacterTemplateRequest) request;
                ct.setType(type);
                ct.setTitle(saveIntDropDownCharacterTemplateRequest.getTitle());
                ct.setPlaceHolder(saveIntDropDownCharacterTemplateRequest.getDescription());
                ct.setIntDropDown(saveIntDropDownCharacterTemplateRequest.getValues());
                return ct;
            }
            case TEXT_DROP_DOWN -> {
                SaveTextDropDownCharacterTemplateRequest saveTextDropDownCharacterTemplateRequest = (SaveTextDropDownCharacterTemplateRequest) request;
                ct.setType(type);
                ct.setTitle(saveTextDropDownCharacterTemplateRequest.getTitle());
                ct.setPlaceHolder(saveTextDropDownCharacterTemplateRequest.getDescription());
                ct.setTextDropDown(saveTextDropDownCharacterTemplateRequest.getValues());
                return ct;
            }
        }
        return null;
    }
}

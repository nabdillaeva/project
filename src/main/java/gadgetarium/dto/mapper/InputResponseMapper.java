package gadgetarium.dto.mapper;

import gadgetarium.dto.response.inputresponses.*;
import gadgetarium.models.CharacterTemplate;

public class InputResponseMapper {

    public static InputResponse mapToInputResponse(CharacterTemplate ct) {
        switch (ct.getType()) {
            case TEXT_VALUE, INT_VALUE, DATE, FILE, COLORS -> {
                return new SimpleInputResponse(
                        ct.getId(),
                        ct.getType(),
                        ct.getTitle(),
                        ct.getPlaceHolder()
                );
            }
            case IMAGES -> {
                return new ImageInputResponse(
                        ct.getId(),
                        ct.getType(),
                        ct.getTitle(),
                        ct.getPlaceHolder(),
                        ct.getImageCount()
                );
            }
            case TEXT_DROP_DOWN -> {
                return new TextDropDownInputResponse(
                        ct.getId(),
                        ct.getType(),
                        ct.getTitle(),
                        ct.getPlaceHolder(),
                        ct.getTextDropDown()
                );
            }
            case INT_DROP_DOWN -> {
                return new IntDropDownInputResponse(
                        ct.getId(),
                        ct.getType(),
                        ct.getTitle(),
                        ct.getPlaceHolder(),
                        ct.getIntDropDown()
                );
            }
        }
        return null;
    }
}

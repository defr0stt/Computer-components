package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CaseData extends ComponentData {
    @NotEmpty(message = "Type can not be empty")
    private String type;

    @NotEmpty(message = "Color can not be empty")
    private String color;

    @Override
    public String toString() {
        return "Case{" +
                "typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year='" + getYear() + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

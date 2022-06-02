package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PowerSupplyData extends ComponentData {

    @NotEmpty(message = "Power can not be empty")
    private Integer power;

    @NotEmpty(message = "Device type can not be empty")
    private String deviceType;

    @Override
    public String toString() {
        return "PowerSupplyData{" +
                "typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", power=" + power +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}

package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CoolerData extends ComponentData {

    @NotEmpty(message = "Type can not be empty")
    private String type;

    @NotEmpty(message = "Tdp can not be empty")
    private String tdp;

    @NotEmpty(message = "Socket can not be empty")
    private String socket;

    @NotEmpty(message = "Base speed can not be empty")
    private Integer speedBase;

    @NotEmpty(message = "Max speed can not be empty")
    private Integer speedMax;

    @Override
    public String toString() {
        return "CoolerData{" +
                "typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", type='" + type + '\'' +
                ", tdp='" + tdp + '\'' +
                ", socket='" + socket + '\'' +
                ", speedBase=" + speedBase +
                ", speedMax=" + speedMax +
                '}';
    }
}

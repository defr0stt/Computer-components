package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MotherboardData extends ComponentData {
    @NotEmpty(message="Socket can not be empty")
    private String socket;

    @NotEmpty(message="Memory can not be empty")
    private String memory;

    @NotEmpty(message="Frequency can not be empty")
    private Integer frequency;

    @NotEmpty(message="Outputs can not be empty")
    private String outputs;

    @Override
    public String toString() {
        return "MotherboardData{" +
                "typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", socket='" + socket + '\'' +
                ", memory='" + memory + '\'' +
                ", frequency=" + frequency +
                ", outputs='" + outputs + '\'' +
                '}';
    }
}

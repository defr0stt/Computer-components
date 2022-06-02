package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemoryData extends ComponentData {

    @NotEmpty(message = "Size can not be empty")
    private Integer memorySize;

    @NotEmpty(message = "Type type can not be empty")
    private String memoryType;

    @NotEmpty(message = "Frequency type can not be empty")
    private Integer frequency;

    @NotEmpty(message = "Device type can not be empty")
    private String device;

    @Override
    public String toString() {
        return "MemoryData{" +
                "typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", memorySize=" + memorySize +
                ", memoryType='" + memoryType + '\'' +
                ", frequency=" + frequency +
                ", device='" + device + '\'' +
                '}';
    }
}

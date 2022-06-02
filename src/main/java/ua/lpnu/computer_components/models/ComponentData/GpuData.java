package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class GpuData extends ComponentData {

    @NotEmpty(message = "Chip name can not be empty")
    private String chipName;

    @NotEmpty(message = "Memory type can not be empty")
    private String memoryType;

    @NotEmpty(message = "Memory size can not be empty")
    private Integer memorySize;

    @NotEmpty(message = "Cooling system can not be empty")
    private String coolingSys;

    @NotEmpty(message = "Frequency can not be empty")
    private Integer frequency;

    @NotEmpty(message = "Resolution name can not be empty")
    private String resolutionMax;

    @Override
    public String toString() {
        return "GPU{" +
                "typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", chipName='" + chipName + '\'' +
                ", memoryType='" + memoryType + '\'' +
                ", memorySize='" + memorySize + '\'' +
                ", coolingSys='" + coolingSys + '\'' +
                ", frequency='" + frequency + '\'' +
                ", resolutionMax='" + resolutionMax + '\'' +
                '}';
    }
}

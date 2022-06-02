package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class HardwareData extends ComponentData {

    @NotEmpty(message = "Size can not be empty")
    private Integer size;

    @NotEmpty(message = "Disk type can not be empty")
    private String diskType;

    @NotEmpty(message = "Connection can not be empty")
    private String connection;

    @NotEmpty(message = "Disk buffer size can not be empty")
    private Integer diskBufferSize;

    @Override
    public String toString() {
        return "Hardware{" +
                "typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", size=" + size +
                ", diskType='" + diskType + '\'' +
                ", connection=" + connection +
                ", diskBufferSize='" + diskBufferSize + '\'' +
                '}';
    }

}

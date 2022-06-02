package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class OsData extends ComponentData {

    @NotEmpty(message = "Edition can not be empty")
    private String edition;

    @NotEmpty(message = "Discharge can not be empty")
    private Integer discharge;

    @Override
    public String toString() {
        return "OsData{" +
                "typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", edition='" + edition + '\'' +
                ", discharge=" + discharge +
                '}';
    }
}

package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public abstract class ComponentData {
    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotEmpty(message = "Type of component can not be empty")
    private String typeOfComponent;

    @NotEmpty(message = "Price can not be empty")
    private String price;

    @NotEmpty(message = "Year can not be empty")
    private String year;
}

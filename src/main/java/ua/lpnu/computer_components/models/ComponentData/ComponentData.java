package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public abstract class ComponentData {
    @NotEmpty(message = "Name can not be empty")
    private String name;

    private String typeOfComponent;

    @NotEmpty(message = "Price can not be empty")
    private Double price;

    @NotEmpty(message = "Year can not be empty")
    private Integer year;
}

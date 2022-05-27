package ua.lpnu.computer_components.models.ComponentData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CpuData extends ComponentData{
    @NotEmpty(message = "Type can not be empty")
    private String type;

    @NotEmpty(message = "Socket name can not be empty")
    private String socket;

    @NotEmpty(message = "Frequency can not be empty")
    private Integer baseFrequency;

    @NotEmpty(message = "Core can not be empty")
    private Integer core;

    @NotEmpty(message = "Threads can not be empty")
    private Integer threadCount;

    @NotEmpty(message = "Temperature can not be empty")
    private Double maxTemperature;

    @NotEmpty(message = "GPU name can not be empty")
    private String graphic;

    @NotEmpty(message = "MAX Frequency can not be empty")
    private Integer maxFrequency;
}

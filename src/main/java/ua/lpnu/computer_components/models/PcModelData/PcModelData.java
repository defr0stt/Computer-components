package ua.lpnu.computer_components.models.PcModelData;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PcModelData {

    @NotEmpty(message = "custom pc name name can not be empty")
    private String customPcName;

    @NotEmpty(message = "cpu name can not be empty")
    private String cpuName;

    @NotEmpty(message = "gpu name can not be empty")
    private String gpuName;

    @NotEmpty(message = "case name can not be empty")
    private String caseName;

    @NotEmpty(message = "cooler name can not be empty")
    private String coolerName;

    @NotEmpty(message = "power supply name can not be empty")
    private String powerSupplyName;

    @NotEmpty(message = "memory name can not be empty")
    private String memoryName;

    @NotEmpty(message = "os name can not be empty")
    private String osName;

    @NotEmpty(message = "motherboard name can not be empty")
    private String motherboardName;

    @NotEmpty(message = "hardware name can not be empty")
    private String hardwareName;

    private Double price = new Double(0);

    private String user = "";

    @Override
    public String toString() {
        return "PcModelData{" +
                "customPcName='" + customPcName + '\'' +
                ", cpuName='" + cpuName + '\'' +
                ", gpuName='" + gpuName + '\'' +
                ", caseName='" + caseName + '\'' +
                ", coolerName='" + coolerName + '\'' +
                ", powerSupplyName='" + powerSupplyName + '\'' +
                ", memoryName='" + memoryName + '\'' +
                ", osName='" + osName + '\'' +
                ", motherboardName='" + motherboardName + '\'' +
                ", hardwareName='" + hardwareName + '\'' +
                ", price=" + price +
                ", user='" + user + '\'' +
                '}';
    }
}

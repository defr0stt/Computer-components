package ua.lpnu.computer_components.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="pc_model")
@Inheritance(strategy = InheritanceType.JOINED)
public class PcModel {

    @Id
    @SequenceGenerator(                     // створення сутності
            name = "pc_model_sequence",
            sequenceName = "pc_model_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pc_model_sequence"
    )
    @Column(name="pc_model_id")
    private Long id;

    @Column(nullable = false, unique = true, name="pc_model_name")
    private String customPcName;

    @Column(nullable = false,name="pc_model_cpu")
    private String cpuName;

    @Column(nullable = false,name="pc_model_gpu")
    private String gpuName;

    @Column(nullable = false,name="pc_model_case")
    private String caseName;

    @Column(nullable = false,name="pc_model_cooler")
    private String coolerName;

    @Column(nullable = false,name="pc_model_power_supply")
    private String powerSupplyName;

    @Column(nullable = false,name="pc_model_memory")
    private String memoryName;

    @Column(nullable = false,name="pc_model_os")
    private String osName;

    @Column(nullable = false,name="pc_model_motherboard")
    private String motherboardName;

    @Column(nullable = false,name="pc_model_hardware")
    private String hardwareName;

    @Column(nullable = false,name="pc_model_price")
    private Double price;

    @Column(nullable = false,name="pc_model_user")
    private String user;

    public PcModel(Long id,
                   String customPcName,
                   String cpuName,
                   String gpuName,
                   String caseName,
                   String coolerName,
                   String powerSupplyName,
                   String memoryName,
                   String osName,
                   String motherboardName,
                   String hardwareName,
                   Double price,
                   String user) {
        this.id = id;
        this.customPcName = customPcName;
        this.cpuName = cpuName;
        this.gpuName = gpuName;
        this.caseName = caseName;
        this.coolerName = coolerName;
        this.powerSupplyName = powerSupplyName;
        this.memoryName = memoryName;
        this.osName = osName;
        this.motherboardName = motherboardName;
        this.hardwareName = hardwareName;
        this.price = price;
        this.user = user;
    }

    public PcModel(String customPcName,
                   String cpuName,
                   String gpuName,
                   String caseName,
                   String coolerName,
                   String powerSupplyName,
                   String memoryName,
                   String osName,
                   String motherboardName,
                   String hardwareName,
                   Double price,
                   String user) {
        this.customPcName = customPcName;
        this.cpuName = cpuName;
        this.gpuName = gpuName;
        this.caseName = caseName;
        this.coolerName = coolerName;
        this.powerSupplyName = powerSupplyName;
        this.memoryName = memoryName;
        this.osName = osName;
        this.motherboardName = motherboardName;
        this.hardwareName = hardwareName;
        this.price = price;
        this.user = user;
    }

    public PcModel(){}

//    @ManyToMany(mappedBy = "pc_model")
//    private Set<UserEntity> users = new HashSet<>();
}

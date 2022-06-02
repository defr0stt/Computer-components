package ua.lpnu.computer_components.models.Components;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity // for hibernate
@Table(name = "gpu_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class GPU extends Component {

    @Column(name="gpu_chip")
    private String chipName;

    @Column(name="gpu_memory_type")
    private String memoryType;

    @Column(name="gpu_memory_size")
    private Integer memorySize;

    @Column(name="gpu_cooling_system")
    private String coolingSys;

    @Column(name="gpu_frequency")
    private Integer frequency;

    @Column(name="gpu_resolution_max")
    private String resolutionMax;

    public GPU() {
    }

    public GPU(Long id,
               String typeOfComponent,
               String name,
               Double price,
               Integer year,
               String chipName,
               String memoryType,
               Integer memorySize,
               String coolingSys,
               Integer frequency,
               String resolutionMax) {
        super(id, typeOfComponent, name, price, year);
        this.chipName = chipName;
        this.memoryType = memoryType;
        this.memorySize = memorySize;
        this.coolingSys = coolingSys;
        this.frequency = frequency;
        this.resolutionMax = resolutionMax;
    }

    public GPU(String typeOfComponent,
               String name,
               Double price,
               Integer year,
               String chipName,
               String memoryType,
               Integer memorySize,
               String coolingSys,
               Integer frequency,
               String resolutionMax) {
        super(typeOfComponent, name, price, year);
        this.chipName = chipName;
        this.memoryType = memoryType;
        this.memorySize = memorySize;
        this.coolingSys = coolingSys;
        this.frequency = frequency;
        this.resolutionMax = resolutionMax;
    }

    GPU(GPU gpu){
        this(gpu.getTypeOfComponent(), gpu.getName(), gpu.getPrice(),
                gpu.getYear(), gpu.getChipName(), gpu.getMemoryType(),
                gpu.getMemorySize(), gpu.getCoolingSys(), gpu.getFrequency(),
                gpu.getResolutionMax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),frequency, resolutionMax);
    }

    @Override
    public boolean equals(Object obj) {
        GPU otherGpu = (GPU)(obj);
        try {
            if(this.getName().equals(otherGpu.getName())){
                if(this.getTypeOfComponent().equals(otherGpu.getTypeOfComponent())){
                    if(this.getPrice().equals(otherGpu.getPrice())){
                        if(this.getYear().equals(otherGpu.getYear())){
                            if(this.getChipName().equals(otherGpu.getChipName())){
                                if(this.getMemoryType().equals(otherGpu.getMemoryType())){
                                    if(this.getMemorySize().equals(otherGpu.getMemorySize())){
                                        if(this.getCoolingSys().equals(otherGpu.getCoolingSys())){
                                            if(this.getFrequency().equals(otherGpu.getFrequency())){
                                                if(this.getResolutionMax().equals(otherGpu.getResolutionMax())){
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        } catch (NullPointerException e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "GPU{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
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

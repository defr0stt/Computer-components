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
@Table(name = "memory_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class Memory extends Component {

    @Column(name = "memory_size")
    private Integer memorySize;

    @Column(name = "memory_type")
    private String memoryType;

    @Column(name = "memory_frequency")
    private Integer frequency;

    @Column(name = "memory_device")
    private String device;

    public Memory(){}

    public Memory(Long id,
                  String typeOfComponent,
                  String name,
                  Double price,
                  Integer year,
                  Integer memorySize,
                  String memoryType,
                  Integer frequency,
                  String device) {
        super(id, typeOfComponent, name, price, year);
        this.memorySize = memorySize;
        this.memoryType = memoryType;
        this.frequency = frequency;
        this.device = device;
    }

    public Memory(String typeOfComponent,
                  String name,
                  Double price,
                  Integer year,
                  Integer memorySize,
                  String memoryType,
                  Integer frequency,
                  String device) {
        super(typeOfComponent, name, price, year);
        this.memorySize = memorySize;
        this.memoryType = memoryType;
        this.frequency = frequency;
        this.device = device;
    }

    public Memory(Memory memory){
        this(memory.getTypeOfComponent(), memory.getName(), memory.getPrice(),
                memory.getYear(), memory.getMemorySize(), memory.getMemoryType(),
                memory.getFrequency(), memory.getDevice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), memorySize, memoryType);
    }

    @Override
    public boolean equals(Object obj) {
        Memory otherMemory = (Memory)(obj);
        try {
            if (this.getName().equals(otherMemory.getName())) {
                if (this.getTypeOfComponent().equals(otherMemory.getTypeOfComponent())) {
                    if (this.getPrice().equals(otherMemory.getPrice())) {
                        if (this.getYear().equals(otherMemory.getYear())) {
                            if (this.getMemorySize().equals(otherMemory.getMemorySize())) {
                                if (this.getMemoryType().equals(otherMemory.getMemoryType())) {
                                    if (this.getFrequency().equals(otherMemory.getFrequency())) {
                                        if (this.getDevice().equals(otherMemory.getDevice())) {
                                            return true;
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
        return "Memory{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
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

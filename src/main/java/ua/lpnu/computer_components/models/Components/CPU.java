package ua.lpnu.computer_components.models.Components;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity // for hibernate
@Table(name = "cpu_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class CPU extends Component {

//    CPU cpu = new CPU("CPU","AMD RYZEN 3750H","Mobile","FP5",1042.0,2019,2300,4,8,105.0);

    @Column(name="cpu_type")
    private String type;

    @Column(name="cpu_socket")
    private String socket;

    @Column(name="cpu_frequency")
    private Integer baseFrequency;

    @Column(name="cpu_cores")
    private Integer core;

    @Column(name="cpu_threads")
    private Integer threadCount;

    @Column(name="cpu_temp")
    private Double maxTemperature;

    @Column(name="cpu_graphic")
    private String graphic;

    @Column(name="cpu_frequency_max")
    private Integer maxFrequency;

    public CPU() {
    }

    public CPU(Long id,
               String typeOfComponent,
               String name,
               String type,
               String socket,
               Double price,
               Integer year,
               Integer baseFrequency,
               Integer core,
               Integer threadCount,
               Double maxTemperature,
               String graphic,
               Integer maxFrequency) {
        super(id, typeOfComponent, name, price, year);
        this.type = type;
        this.socket = socket;
        this.baseFrequency = baseFrequency;
        this.core = core;
        this.threadCount = threadCount;
        this.maxTemperature = maxTemperature;
        this.graphic = graphic;
        this.maxFrequency = maxFrequency;
    }

    public CPU(String typeOfComponent,
               String name,
               String type,
               String socket,
               Double price,
               Integer year,
               Integer baseFrequency,
               Integer core,
               Integer threadCount,
               Double maxTemperature,
               String graphic,
               Integer maxFrequency) {
        super(typeOfComponent, name, price, year);
        this.type = type;
        this.socket = socket;
        this.baseFrequency = baseFrequency;
        this.core = core;
        this.threadCount = threadCount;
        this.maxTemperature = maxTemperature;
        this.graphic = graphic;
        this.maxFrequency = maxFrequency;
    }

    public CPU(CPU cpu){
        this(cpu.getTypeOfComponent(), cpu.getName(), cpu.getType(),
                cpu.getSocket(), cpu.getPrice(), cpu.getYear(),
                cpu.getBaseFrequency(), cpu.getCore(), cpu.getThreadCount(),
                cpu.getMaxTemperature(), cpu.getGraphic(), cpu.getMaxFrequency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),baseFrequency, maxFrequency);
    }

    @Override
    public boolean equals(Object obj) {
        CPU otherCpu = (CPU)(obj);
        try {
            if (this.getName().equals(otherCpu.getName())) {
                if (this.getTypeOfComponent().equals(otherCpu.getTypeOfComponent())) {
                    if (this.getPrice().equals(otherCpu.getPrice())) {
                        if (this.getYear().equals(otherCpu.getYear())) {
                            if (this.getType().equals(otherCpu.getType())) {
                                if (this.getSocket().equals(otherCpu.getSocket())) {
                                    if (this.getBaseFrequency().equals(otherCpu.getBaseFrequency())) {
                                        if (this.getCore().equals(otherCpu.getCore())) {
                                            if (this.getThreadCount().equals(otherCpu.getThreadCount())) {
                                                if (this.getMaxTemperature().equals(otherCpu.getMaxTemperature())) {
                                                    if (this.getMaxFrequency().equals(otherCpu.getMaxFrequency())) {
                                                        if (this.getGraphic().equals(otherCpu.getGraphic())) {
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
                }
            }
            return false;
        } catch (NullPointerException e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", type='" + type + '\'' +
                ", socket='" + socket + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", baseFrequency=" + baseFrequency +
                ", core=" + core +
                ", threadCount=" + threadCount +
                ", maxTemperature=" + maxTemperature +
                ", graphic=" + graphic +
                ", maxFrequency=" + maxFrequency +
                '}';
    }
}

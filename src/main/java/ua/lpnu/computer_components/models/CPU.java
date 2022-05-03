package ua.lpnu.computer_components.models;

import javax.persistence.*;

@Entity // for hibernate
@Table(name = "cpu")  // for table in DB
@PrimaryKeyJoinColumn(name = "id")
public class CPU extends Component {

//    CPU cpu = new CPU("CPU","AMD RYZEN 3750H","Mobile","FP5",1042.0,2019,2300,4,8,105.0);

    private String type;
    private String socket;
    private Integer baseFrequency;
    private Integer core;
    private Integer threadCount;
    private Double maxTemperature;

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
               Double maxTemperature) {
        super(id, typeOfComponent, name, price, year);
        this.type = type;
        this.socket = socket;
        this.baseFrequency = baseFrequency;
        this.core = core;
        this.threadCount = threadCount;
        this.maxTemperature = maxTemperature;
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
               Double maxTemperature) {
        super(typeOfComponent, name, price, year);
        this.type = type;
        this.socket = socket;
        this.baseFrequency = baseFrequency;
        this.core = core;
        this.threadCount = threadCount;
        this.maxTemperature = maxTemperature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public Integer getBaseFrequency() {
        return baseFrequency;
    }

    public void setBaseFrequency(Integer baseFrequency) {
        this.baseFrequency = baseFrequency;
    }

    public Integer getCore() {
        return core;
    }

    public void setCore(Integer core) {
        this.core = core;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
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
                '}';
    }
}

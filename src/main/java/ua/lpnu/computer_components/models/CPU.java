package ua.lpnu.computer_components.models;

import javax.persistence.*;

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

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public Integer getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(Integer maxFrequency) {
        this.maxFrequency = maxFrequency;
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

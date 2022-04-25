package ua.lpnu.computer_components.models;

import javax.persistence.*;

@Entity // for hibernate
@Table  // for table in DB
public class CPU {
    @Id
    @SequenceGenerator(                     // створення сутності
            name = "cpu_sequence",
            sequenceName = "cpu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cpu_sequence"
    )

    private Long id;
    private String typeOfComponent;
    private String name;
    private String type;
    private String socket;
    private Double price;
    private Integer year;
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
        this.id = id;
        this.typeOfComponent = typeOfComponent;
        this.name = name;
        this.type = type;
        this.socket = socket;
        this.price = price;
        this.year = year;
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
        this.typeOfComponent = typeOfComponent;
        this.name = name;
        this.type = type;
        this.socket = socket;
        this.price = price;
        this.year = year;
        this.baseFrequency = baseFrequency;
        this.core = core;
        this.threadCount = threadCount;
        this.maxTemperature = maxTemperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfComponent() {
        return typeOfComponent;
    }

    public void setTypeOfComponent(String typeOfComponent) {
        this.typeOfComponent = typeOfComponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", socket='" + socket + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", baseFrequency=" + baseFrequency +
                ", core=" + core +
                ", threadCount=" + threadCount +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}

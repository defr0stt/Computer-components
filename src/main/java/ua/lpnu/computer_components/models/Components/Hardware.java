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
@Table(name = "hardware_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class Hardware extends Component {

    @Column(name = "disk_size")
    private Integer size;

    @Column(name = "disk_type")
    private String diskType;

    @Column(name = "disk_connection")
    private String connection;

    @Column(name = "disk_buffer_size")
    private Integer diskBufferSize;

    public Hardware(){}

    public Hardware(Long id,
                    String typeOfComponent,
                    String name,
                    Double price,
                    Integer year,
                    Integer size,
                    String diskType,
                    String connection,
                    Integer diskBufferSize) {
        super(id, typeOfComponent, name, price, year);
        this.size = size;
        this.diskType = diskType;
        this.connection = connection;
        this.diskBufferSize = diskBufferSize;
    }

    public Hardware(String typeOfComponent,
                    String name,
                    Double price,
                    Integer year,
                    Integer size,
                    String diskType,
                    String connection,
                    Integer diskBufferSize) {
        super(typeOfComponent, name, price, year);
        this.size = size;
        this.diskType = diskType;
        this.connection = connection;
        this.diskBufferSize = diskBufferSize;
    }

    public Hardware(Hardware hardware){
        this(hardware.getTypeOfComponent(), hardware.getName(), hardware.getPrice(),
                hardware.getYear(), hardware.getSize(), hardware.getDiskType(),
                hardware.getConnection(), hardware.getDiskBufferSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), connection, diskBufferSize);
    }

    @Override
    public boolean equals(Object obj) {
        Hardware otherHard = (Hardware)(obj);
        try {
            if (this.getName().equals(otherHard.getName())) {
                if (this.getTypeOfComponent().equals(otherHard.getTypeOfComponent())) {
                    if (this.getPrice().equals(otherHard.getPrice())) {
                        if (this.getYear().equals(otherHard.getYear())) {
                            if (this.getSize().equals(otherHard.getSize())) {
                                if (this.getDiskType().equals(otherHard.getDiskType())) {
                                    if (this.getConnection().equals(otherHard.getConnection())) {
                                        if (this.getDiskBufferSize().equals(otherHard.getDiskBufferSize())) {
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
        return "Hardware{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", size=" + size +
                ", diskType='" + diskType + '\'' +
                ", connection=" + connection +
                ", diskBufferSize='" + diskBufferSize + '\'' +
                '}';
    }
}

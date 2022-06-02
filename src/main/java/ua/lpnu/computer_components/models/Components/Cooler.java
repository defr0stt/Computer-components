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
@Table(name = "cooler_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class Cooler extends Component {

    @Column(name="cooler_type")
    private String type;

    @Column(name="cooler_tdp")
    private String tdp;

    @Column(name="cooler_socket")
    private String socket;

    @Column(name="cooler_speed_base")
    private Integer speedBase;

    @Column(name="cooler_speed_max")
    private Integer speedMax;

    public Cooler() {
    }

    public Cooler(Long id,
                  String typeOfComponent,
                  String name,
                  Double price,
                  Integer year,
                  String type,
                  String tdp,
                  String socket,
                  Integer speedBase,
                  Integer speedMax) {
        super(id, typeOfComponent, name, price, year);
        this.type = type;
        this.tdp = tdp;
        this.socket = socket;
        this.speedBase = speedBase;
        this.speedMax = speedMax;
    }

    public Cooler(String typeOfComponent,
                  String name,
                  Double price,
                  Integer year,
                  String type,
                  String tdp,
                  String socket,
                  Integer speedBase,
                  Integer speedMax) {
        super(typeOfComponent, name, price, year);
        this.type = type;
        this.tdp = tdp;
        this.socket = socket;
        this.speedBase = speedBase;
        this.speedMax = speedMax;
    }

    public Cooler(Cooler cooler){
        this(cooler.getTypeOfComponent(), cooler.getName(), cooler.getPrice(),
                cooler.getYear(), cooler.getType(), cooler.getTdp(),cooler.getSocket(),
                cooler.getSpeedBase(), cooler.getSpeedMax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), speedBase, speedMax);
    }

    @Override
    public boolean equals(Object obj) {
        Cooler otherCooler = (Cooler)(obj);
        try {
            if (this.getName().equals(otherCooler.getName())) {
                if (this.getTypeOfComponent().equals(otherCooler.getTypeOfComponent())) {
                    if (this.getPrice().equals(otherCooler.getPrice())) {
                        if (this.getYear().equals(otherCooler.getYear())) {
                            if (this.getType().equals(otherCooler.getType())) {
                                if (this.getTdp().equals(otherCooler.getTdp())) {
                                    if (this.getSocket().equals(otherCooler.getSocket())) {
                                        if (this.getSpeedBase().equals(otherCooler.getSpeedBase())) {
                                            if (this.getSpeedMax().equals(otherCooler.getSpeedMax())) {
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
            return false;
        } catch (NullPointerException e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cooler{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", type='" + type + '\'' +
                ", tdp='" + tdp + '\'' +
                ", socket='" + socket + '\'' +
                ", speedBase=" + speedBase +
                ", speedMax=" + speedMax +
                '}';
    }
}

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
@Table(name = "power_supply_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class PowerSupply extends Component{

    @Column(name = "supply_power")
    private Integer power;

    @Column(name = "supply_type")
    private String deviceType;

    public PowerSupply(){}

    public PowerSupply(Long id,
                       String typeOfComponent,
                       String name,
                       Double price,
                       Integer year,
                       Integer power,
                       String deviceType) {
        super(id, typeOfComponent, name, price, year);
        this.power = power;
        this.deviceType = deviceType;
    }

    public PowerSupply(String typeOfComponent,
                       String name,
                       Double price,
                       Integer year,
                       Integer power,
                       String deviceType) {
        super(typeOfComponent, name, price, year);
        this.power = power;
        this.deviceType = deviceType;
    }

    public PowerSupply(PowerSupply powerSupply){
        this(powerSupply.getTypeOfComponent(), powerSupply.getName(), powerSupply.getPrice(),
                powerSupply.getYear(), powerSupply.getPower(), powerSupply.getDeviceType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), power, deviceType);
    }

    @Override
    public boolean equals(Object obj) {
        PowerSupply otherSupply = (PowerSupply)(obj);
        try {
            if (this.getName().equals(otherSupply.getName())) {
                if (this.getTypeOfComponent().equals(otherSupply.getTypeOfComponent())) {
                    if (this.getPrice().equals(otherSupply.getPrice())) {
                        if (this.getYear().equals(otherSupply.getYear())) {
                            if (this.getPower().equals(otherSupply.getPower())) {
                                if (this.getDeviceType().equals(otherSupply.getDeviceType())) {
                                    return true;
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
        return "PowerSupply{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", power=" + power +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}

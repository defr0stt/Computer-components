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
@Table(name = "os_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class OS extends Component{

    @Column(name="os_edition")
    private String edition;

    @Column(name="os_discharge")
    private Integer discharge;

    public OS(){}

    public OS(Long id,
              String typeOfComponent,
              String name,
              Double price,
              Integer year,
              String edition,
              Integer discharge) {
        super(id, typeOfComponent, name, price, year);
        this.edition = edition;
        this.discharge = discharge;
    }

    public OS(String typeOfComponent,
              String name,
              Double price,
              Integer year,
              String edition,
              Integer discharge) {
        super(typeOfComponent, name, price, year);
        this.edition = edition;
        this.discharge = discharge;
    }

    public OS(OS os){
        this(os.getTypeOfComponent(),os.getName(),os.getPrice(),
                os.getYear(), os.getEdition(), os.getDischarge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), edition, discharge);
    }

    @Override
    public boolean equals(Object obj) {
        OS otherOs = (OS)(obj);
        try {
            if (this.getName().equals(otherOs.getName())) {
                if (this.getTypeOfComponent().equals(otherOs.getTypeOfComponent())) {
                    if (this.getPrice().equals(otherOs.getPrice())) {
                        if (this.getYear().equals(otherOs.getYear())) {
                            if (this.getEdition().equals(otherOs.getEdition())) {
                                if (this.getDischarge().equals(otherOs.getDischarge())) {
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
        return "OS{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", edition='" + edition + '\'' +
                ", discharge=" + discharge +
                '}';
    }
}

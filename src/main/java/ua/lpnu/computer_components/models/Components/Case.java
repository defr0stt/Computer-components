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
@Table(name = "case_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class Case extends Component {

    @Column(name="case_type")
    private String type;

    @Column(name="case_color")
    private String color;

    public Case() {}

    public Case(Long id,
                String typeOfComponent,
                String name,
                Double price,
                Integer year,
                String type,
                String color) {
        super(id, typeOfComponent, name, price, year);
        this.type = type;
        this.color = color;
    }

    public Case(String typeOfComponent,
                String name,
                Double price,
                Integer year,
                String type,
                String color) {
        super(typeOfComponent, name, price, year);
        this.type = type;
        this.color = color;
    }

    public Case(Case aCase) {
        this(aCase.getTypeOfComponent(), aCase.getName(), aCase.getPrice(),
                aCase.getYear(), aCase.getType(), aCase.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }

    @Override
    public boolean equals(Object obj) {
        Case otherCase = (Case) (obj);
        try {
            if (this.getName().equals(otherCase.getName())) {
                if (this.getTypeOfComponent().equals(otherCase.getTypeOfComponent())) {
                    if (this.getPrice().equals(otherCase.getPrice())) {
                        if (this.getYear().equals(otherCase.getYear())) {
                            if (this.getType().equals(otherCase.getType())) {
                                if (this.getColor().equals(otherCase.getColor())) {
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
        return "Case{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year='" + getYear() + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

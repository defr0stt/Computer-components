package ua.lpnu.computer_components.models.Components;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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

    @Override
    public String toString() {
        return "Case{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", year='" + getYear() + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

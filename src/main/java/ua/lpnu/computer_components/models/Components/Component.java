package ua.lpnu.computer_components.models.Components;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="component")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Component {
    @Id
    @SequenceGenerator(                     // створення сутності
            name = "component_sequence",
            sequenceName = "component_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "component_sequence"
    )
    @Column(name="component_id")
    private Long id;

    @Column(nullable = false,name="component_type")
    private String typeOfComponent;

    @Column(unique = true, nullable = false, name="component_name")
    private String name;

    @Column(nullable = false,name="component_price")
    private Double price;

    @Column(nullable = false,name="component_year")
    private Integer year;

    public Component(Long id, String typeOfComponent, String name, Double price, Integer year) {
        this.id = id;
        this.typeOfComponent = typeOfComponent;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public Component(String typeOfComponent, String name, Double price, Integer year) {
        this.typeOfComponent = typeOfComponent;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public Component(){}
}
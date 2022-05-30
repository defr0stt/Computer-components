package ua.lpnu.computer_components.models.Components;

import javax.persistence.*;

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

    public static Component checkMainParams(Component c1, Component c2){
        if(!c1.getName().equals(c2.getName())){
            c1.setName(c2.getName());
        }
        if(!c1.getPrice().equals(c2.getPrice())){
            c1.setPrice(c2.getPrice());
        }
        if(!c1.getYear().equals(c2.getYear())){
            c1.setYear(c2.getYear());
        }
        return c1;
    }

    public Component(){}

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
}
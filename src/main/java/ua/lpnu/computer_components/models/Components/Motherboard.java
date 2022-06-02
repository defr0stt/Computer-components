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
@Table(name = "motherboard_details")  // for table in DB
@PrimaryKeyJoinColumn(name = "component_id")
public class Motherboard extends Component {

    @Column(name="motherboard_socket")
    private String socket;

    @Column(name="motherboard_memory")
    private String memory;

    @Column(name="motherboard_frequency")
    private Integer frequency;

    @Column(name="motherboard_outputs")
    private String outputs;

    public Motherboard(){}

    public Motherboard(Long id,
                       String typeOfComponent,
                       String name, Double price,
                       Integer year, String socket,
                       String memory,
                       Integer frequency,
                       String outputs) {
        super(id, typeOfComponent, name, price, year);
        this.socket = socket;
        this.memory = memory;
        this.frequency = frequency;
        this.outputs = outputs;
    }

    public Motherboard(String typeOfComponent,
                       String name,
                       Double price,
                       Integer year,
                       String socket,
                       String memory,
                       Integer frequency,
                       String outputs) {
        super(typeOfComponent, name, price, year);
        this.socket = socket;
        this.memory = memory;
        this.frequency = frequency;
        this.outputs = outputs;
    }

    public Motherboard(Motherboard motherboard){
        this(motherboard.getTypeOfComponent(),motherboard.getName(),motherboard.getPrice(),
                motherboard.getYear(), motherboard.getSocket(), motherboard.getMemory(),
                motherboard.getFrequency(), motherboard.getOutputs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), socket, frequency);
    }

    @Override
    public boolean equals(Object obj) {
        Motherboard otherBoard = (Motherboard)(obj);
        try {
            if(this.getName().equals(otherBoard.getName())){
                if(this.getTypeOfComponent().equals(otherBoard.getTypeOfComponent())){
                    if(this.getPrice().equals(otherBoard.getPrice())){
                        if(this.getYear().equals(otherBoard.getYear())){
                            if(this.getSocket().equals(otherBoard.getSocket())){
                                if(this.getMemory().equals(otherBoard.getMemory())){
                                    if(this.getFrequency().equals(otherBoard.getFrequency())){
                                        if(this.getOutputs().equals(otherBoard.getOutputs())){
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
        return "Motherboard{" +
                "id=" + getId() +
                ", typeOfComponent='" + getTypeOfComponent() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", socket='" + socket + '\'' +
                ", memory='" + memory + '\'' +
                ", frequency=" + frequency +
                ", outputs='" + outputs + '\'' +
                '}';
    }
}

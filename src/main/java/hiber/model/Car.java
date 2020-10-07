package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    @Id
    @Column(name = "series", unique = true)
    private int series;

    @Column(name = "name")
    private String name;

    public Car() {
    }

    public Car(String name, int series) {
        this.name = name;
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}

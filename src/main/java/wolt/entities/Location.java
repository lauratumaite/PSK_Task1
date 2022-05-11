package wolt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "LOCATION")
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "select a from Location as a")
})
public class Location {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "FULL_NAME")
    String fullName;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    public Location(String fullName) {
        this.fullName = fullName;
    }

    public Location(String fullName, Restaurant restaurant) {
        this(fullName);
        this.restaurant = restaurant;
    }
}

package wolt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

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
public class Location implements Serializable {

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

    @Column(name = "LOCATION_ID")
    private Integer locationId;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Location(String fullName, Restaurant restaurant) {
        this(fullName);
        this.restaurant = restaurant;
    }
}

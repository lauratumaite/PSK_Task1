package wolt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "RESTAURANT")
@NamedQueries({
        @NamedQuery(name = "Restaurant.findAll", query = "select a from Restaurant as a"),
        @NamedQuery(name = "Restaurant.findByName", query = "select a from Restaurant as a where a.title= :name")
})
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Size(max = 50)
    @Column(name = "TITLE")
    String title;

    @OneToMany
    @JoinColumn(name = "RESTAURANT_ID")
    List<Location> location = new ArrayList<>();

    @ManyToMany(mappedBy = "restaurants")
    List<Food> foods;

    public Restaurant(String title) {
        this.title = title;
    }

    public Restaurant(String title, List<Location> location) {
        this(title);
        this.location = location;
    }

}

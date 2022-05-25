package wolt.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.io.Serializable;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "FOOD")
@NamedQueries({
        @NamedQuery(name = "Food.findAll", query = "select a from Food as a"),
        @NamedQuery(name = "Food.findByName", query = "select a from Food as a where lower(a.name) = lower(:name)")
})
@EqualsAndHashCode
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "NAME")
    String name;

    @Column
    @ManyToMany
    @JoinTable(
            name = "RESTAURANT_FOOD",
            joinColumns = @JoinColumn(name = "FOOD_ID"),
            inverseJoinColumns = @JoinColumn(name = "RESTAURANT_ID")
    )
    List<Restaurant> restaurants;


    public Food (String name) {
        this.name = name;
    }
}

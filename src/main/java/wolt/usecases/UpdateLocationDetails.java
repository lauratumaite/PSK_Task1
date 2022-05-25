package wolt.usecases;

import wolt.entities.Location;
import wolt.persistence.LocationDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static javax.faces.context.FacesContext.getCurrentInstance;

@Named
@Getter
@Setter
@ViewScoped
public class UpdateLocationDetails implements Serializable{

    private Location location;

    @Inject
    private LocationDAO locationDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateLocationDetails INIT CALLED");
        Map<String, String> requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        int locationId = parseInt(requestParams.get("locationId"));
        this.location = locationDAO.findOne(locationId);
    }

    @Transactional
    public String updateLocationId() {
        try {
            locationDAO.update(this.location);
        } catch (OptimisticLockException e) {
            return "/locationDetails.xhtml?faces-redirect=true&locationId=" + this.location.getId() + "&error=optimistic-lock-exception";
        }
        return "locations.xhtml?restaurantId=" + this.location.getRestaurant().getId() + "&faces-redirect=true";
    }
}

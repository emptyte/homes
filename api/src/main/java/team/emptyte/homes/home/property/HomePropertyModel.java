package team.emptyte.homes.home.property;

import org.fenixteam.storage.model.Model;
import org.jetbrains.annotations.NotNull;
import team.emptyte.homes.home.model.HomeModel;
import team.emptyte.homes.location.LocationModel;

/**
 * Represents a home property model.
 * <p>
 * This model is used to store the home properties.
 *
 * @param id       the home id based on the {@link HomeModel#id()}
 * @param locationModel the home location based on the {@link LocationModel}
 */
public record HomePropertyModel(@NotNull String id, @NotNull LocationModel locationModel) implements Model {
}

package team.emptyte.homes.location;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public record LocationModel(
  @NotNull String world,
  double x,
  double y,
  double z,
  float yaw,
  float pitch
) {
  public LocationModel(@NotNull Location location) {
    this(
      location.getWorld().getName(),
      location.getX(),
      location.getY(),
      location.getZ(),
      location.getYaw(),
      location.getPitch()
    );
  }

  public @NotNull Location toLocation() {
    return new Location(
      org.bukkit.Bukkit.getWorld(this.world),
      this.x,
      this.y,
      this.z,
      this.yaw,
      this.pitch
    );
  }
}

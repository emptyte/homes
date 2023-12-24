package team.emptyte.homes.user;

import org.bukkit.entity.Player;
import org.fenixteam.storage.model.Model;
import org.jetbrains.annotations.NotNull;
import team.emptyte.homes.home.property.HomePropertyModel;

import java.util.List;
import java.util.UUID;

public class UserModel implements Model {
  private final UUID uuid;
  private final String name;

  private List<HomePropertyModel> homes;

  UserModel(final @NotNull Player player) {
    this.uuid = player.getUniqueId();
    this.name = player.getName();
  }

  UserModel(final @NotNull UUID uuid, final @NotNull String name, final @NotNull List<HomePropertyModel> homes) {
    this.uuid = uuid;
    this.name = name;
    this.homes = homes;
  }

  @Override
  public @NotNull String id() {
    return this.uuid.toString();
  }

  public @NotNull UUID uuid() {
    return this.uuid;
  }

  public @NotNull String name() {
    return this.name;
  }

  public @NotNull List<HomePropertyModel> homes() {
    return this.homes;
  }

  public void homes(final @NotNull List<HomePropertyModel> homes) {
    this.homes = homes;
  }

  public void addHome(final @NotNull HomePropertyModel homePropertyModel) {
    this.homes.add(homePropertyModel);
  }

  public void removeHome(final @NotNull HomePropertyModel homePropertyModel) {
    this.homes.remove(homePropertyModel);
  }

  public void removeHome(final @NotNull String id) {
    this.homes.removeIf(homePropertyModel -> homePropertyModel.id().equals(id));
  }

  public void clearHomes() {
    this.homes.clear();
  }
}

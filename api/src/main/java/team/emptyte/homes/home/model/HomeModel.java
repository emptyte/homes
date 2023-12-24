package team.emptyte.homes.home.model;

import net.kyori.adventure.text.Component;
import org.fenixteam.storage.model.Model;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Home model.
 *
 * @since 1.0.0
 */
public record HomeModel(
  @NotNull String id,
  @NotNull Component name,
  @NotNull List<Component> description,
  @Nullable Temporary temporary
) implements Model {

  public static class Temporary {
    long duration;
    int maxUses;

    /**
     * Temporary home data.
     *
     * @param duration in milliseconds
     * @param maxUses maximum uses
     */
    public Temporary(final long duration, final int maxUses) {
      this.duration = duration;
      this.maxUses = maxUses;
    }

    public long duration() {
      return this.duration;
    }

    public int maxUses() {
      return this.maxUses;
    }
  }
}

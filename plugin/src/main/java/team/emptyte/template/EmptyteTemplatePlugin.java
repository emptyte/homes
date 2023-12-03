package team.emptyte.template;

import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Injector;

@SuppressWarnings("unused")
public final class EmptyteTemplatePlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    final var injector = Injector.create(new MainModule());
  }
}

package team.emptyte.template.adapt;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import team.unnamed.inject.AbstractModule;

public final class AdaptionModuleFactory {

  private AdaptionModuleFactory() {
    throw new UnsupportedOperationException();
  }

  public static @NotNull AbstractModule create() {
    final var serverVersion = Bukkit.getServer()
                                .getClass()
                                .getPackage()
                                .getName()
                                .split("\\.")[3]
                                .substring(1);
    final var className = AdaptionModuleFactory.class.getPackage()
                            .getName() + ".v" + serverVersion + ".AdaptionModule";
    try {
      final var clazz = Class.forName(className);
      final var module = clazz.getDeclaredConstructor()
                           .newInstance();
      if (!(module instanceof AbstractModule abstractModule)) {
        throw new IllegalStateException("Invalid adaption module: '"
                                        + className + "'. It doesn't implement " + AbstractModule.class);
      }
      return abstractModule;
    } catch (final ClassNotFoundException e) {
      throw new IllegalStateException("Adaption module not found: '" + className + '.');
    } catch (final ReflectiveOperationException e) {
      throw new IllegalStateException("Failed to instantiate adaption module", e);
    }
  }
}

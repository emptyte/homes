package team.emptyte.template;

import org.jetbrains.annotations.NotNull;
import team.emptyte.inject.binder.ProtectedBinder;
import team.emptyte.paper.core.InjectedPlugin;

@SuppressWarnings("unused")
public final class EmptyteHomesPlugin extends InjectedPlugin {

  @Override
  public void onEnable() {

  }

  @Override
  public void configure(@NotNull final ProtectedBinder binder) {
    binder.install(new MainModule());
  }
}

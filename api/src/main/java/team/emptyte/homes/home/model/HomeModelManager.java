package team.emptyte.homes.home.model;

import org.fenixteam.storage.repository.AsyncModelRepository;
import org.jetbrains.annotations.NotNull;

public final class HomeModelManager {
  private final AsyncModelRepository<HomeModel> repository;

  public HomeModelManager(final @NotNull AsyncModelRepository<HomeModel> repository) {
    this.repository = repository;
  }


}

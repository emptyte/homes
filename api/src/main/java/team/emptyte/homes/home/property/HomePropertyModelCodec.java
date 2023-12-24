package team.emptyte.homes.home.property;

import com.google.gson.JsonObject;
import org.fenixteam.storage.codec.ModelDeserializer;
import org.fenixteam.storage.codec.ModelSerializer;
import org.fenixteam.storage.gson.codec.JsonReader;
import org.fenixteam.storage.gson.codec.JsonWriter;
import org.jetbrains.annotations.NotNull;
import team.emptyte.homes.location.LocationModelCodec;

public final class HomePropertyModelCodec {
  private HomePropertyModelCodec() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }

  public enum HomePropertySerializer implements ModelSerializer<HomePropertyModel, JsonObject> {
    INSTANCE;

    @Override
    public @NotNull JsonObject serialize(final @NotNull HomePropertyModel homePropertyModel) {
      return JsonWriter.create()
        .writeString("id", homePropertyModel.id())
        .writeObject(
          "locationModel",
          homePropertyModel.locationModel(),
          LocationModelCodec.LocationSerializer.INSTANCE
        )
        .end();
    }
  }

  public enum HomePropertyDeserializer implements ModelDeserializer<HomePropertyModel, JsonObject> {
    INSTANCE;

    @Override
    public @NotNull HomePropertyModel deserialize(final @NotNull JsonObject jsonObject) {
      final var reader = JsonReader.create(jsonObject);
      final var id = reader.readString("id");
      if (id == null) throw new NullPointerException("id");
      final var locationModel = reader.readObject("locationModel", LocationModelCodec.LocationDeserializer.INSTANCE);
      if (locationModel == null) throw new NullPointerException("locationModel");

      return new HomePropertyModel(
        id,
        locationModel
      );
    }
  }
}

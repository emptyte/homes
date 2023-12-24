package team.emptyte.homes.location;

import com.google.gson.JsonObject;
import org.fenixteam.storage.codec.ModelDeserializer;
import org.fenixteam.storage.codec.ModelSerializer;
import org.fenixteam.storage.gson.codec.JsonReader;
import org.fenixteam.storage.gson.codec.JsonWriter;
import org.jetbrains.annotations.NotNull;

public final class LocationModelCodec {
  private LocationModelCodec() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }

  public enum LocationSerializer implements ModelSerializer<LocationModel, JsonObject> {
    INSTANCE;

    @Override
    public @NotNull JsonObject serialize(final @NotNull LocationModel locationModel) {
      return JsonWriter.create()
        .writeString("world", locationModel.world())
        .writeNumber("x", locationModel.x())
        .writeNumber("y", locationModel.y())
        .writeNumber("z", locationModel.z())
        .writeNumber("yaw", locationModel.yaw())
        .writeNumber("pitch", locationModel.pitch())
        .end();
    }
  }

  public enum LocationDeserializer implements ModelDeserializer<LocationModel, JsonObject> {
    INSTANCE;

    @Override
    public @NotNull LocationModel deserialize(final @NotNull JsonObject jsonObject) {
      final var reader = JsonReader.create(jsonObject);
      final var world = reader.readString("world");
      if (world == null) throw new NullPointerException("world");
      final var x = reader.readNumber("x");
      if (x == null) throw new NullPointerException("x");
      final var y = reader.readNumber("y");
      if (y == null) throw new NullPointerException("y");
      final var z = reader.readNumber("z");
      if (z == null) throw new NullPointerException("z");
      final var yaw = reader.readNumber("yaw");
      if (yaw == null) throw new NullPointerException("yaw");
      final var pitch = reader.readNumber("pitch");
      if (pitch == null) throw new NullPointerException("pitch");

      return new LocationModel(
        world,
        x.doubleValue(),
        y.doubleValue(),
        z.doubleValue(),
        yaw.floatValue(),
        pitch.floatValue()
      );
    }
  }
}

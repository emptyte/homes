package team.emptyte.homes.user;

import com.google.gson.JsonObject;
import org.fenixteam.storage.codec.ModelDeserializer;
import org.fenixteam.storage.codec.ModelSerializer;
import org.fenixteam.storage.gson.codec.JsonReader;
import org.fenixteam.storage.gson.codec.JsonWriter;
import org.jetbrains.annotations.NotNull;
import team.emptyte.homes.home.property.HomePropertyModelCodec;

import java.util.ArrayList;

public final class UserModelCodec {
  private UserModelCodec() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }

  public enum UserSerializer implements ModelSerializer<UserModel, JsonObject> {
    INSTANCE;

    @Override
    public @NotNull JsonObject serialize(final @NotNull UserModel userModel) {
      return JsonWriter.create()
        .writeUuid("uuid", userModel.uuid())
        .writeString("name", userModel.name())
        .writeCollection(
          "homes",
          userModel.homes(),
          HomePropertyModelCodec.HomePropertySerializer.INSTANCE
        )
        .end();
    }
  }

  public enum UserDeserializer implements ModelDeserializer<UserModel, JsonObject> {
    INSTANCE;

    @Override
    public @NotNull UserModel deserialize(final @NotNull JsonObject jsonObject) {
      final var reader = JsonReader.create(jsonObject);
      final var uuid = reader.readDetailedUuid("uuid");
      if (uuid == null) throw new NullPointerException("uuid");
      final var name = reader.readString("name");
      if (name == null) throw new NullPointerException("name");
      final var homes = reader.readCollection("homes", ArrayList::new, HomePropertyModelCodec.HomePropertyDeserializer.INSTANCE);
      if (homes == null) throw new NullPointerException("homes");

      return new UserModel(
        uuid,
        name,
        homes
      );
    }
  }
}

package bugreport.serde;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, property = "type"
)
public sealed interface RecordCommandBroken {
  String getFooBar();

  @JsonTypeName("print")
  record PrintCommand(String foo) implements RecordCommandBroken {

    @Override
    public String getFooBar() {
      return null;
    }
  }
}

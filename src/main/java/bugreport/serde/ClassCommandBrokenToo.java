package bugreport.serde;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, property = "type"
)
public interface ClassCommandBrokenToo {
  @JsonTypeName("print")
  final class PrintCommand implements ClassCommandBrokenToo {
    private String foo;

    public PrintCommand(String foo) {
      this.foo = foo;
    }

    public String getFoo() {
      return foo;
    }

    public void setFoo(String foo) {
      this.foo = foo;
    }
  }
}

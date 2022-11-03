package bugreport.serde;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.micronaut.serde.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
public class SerdeInterfacesCommandTest {

  @Test
  public void testClassCommandWorking(ObjectMapper objectMapper) throws IOException {
    String printSerialized = objectMapper.writeValueAsString(new ClassCommandWorking.PrintCommand("foo"));
    Object obj = objectMapper.readValue(
        printSerialized,
        ClassCommandWorking.class);
  }

  @Test
  public void testClassCommandBroken(ObjectMapper objectMapper) throws IOException {
    String printSerialized = objectMapper.writeValueAsString(new ClassCommandBroken.PrintCommand("foo"));
    Object obj = objectMapper.readValue(
        printSerialized,
        ClassCommandBroken.class);
  }

  @Test
  public void testClassCommandBrokenToo(ObjectMapper objectMapper) throws IOException {
    String printSerialized = objectMapper.writeValueAsString(new ClassCommandBrokenToo.PrintCommand("foo"));
    Object obj = objectMapper.readValue(
        printSerialized,
        ClassCommandBrokenToo.class);
  }

  @Test
  public void testRecordCommandBroken(ObjectMapper objectMapper) throws IOException {
    String printSerialized = objectMapper.writeValueAsString(new RecordCommandBroken.PrintCommand("foo"));
    Object obj = objectMapper.readValue(
        printSerialized,
        RecordCommandBroken.class);
  }

  @Test
  public void testRecordCommandBrokenToo(ObjectMapper objectMapper) throws IOException {
    String printSerialized = objectMapper.writeValueAsString(new RecordCommandBrokenToo.PrintCommand("foo"));
    Object obj = objectMapper.readValue(
        printSerialized,
        RecordCommandBrokenToo.class);
  }

  @Test
  public void testAbstractClassCommandWorking(ObjectMapper objectMapper) throws IOException {
    String printSerialized = objectMapper.writeValueAsString(new AbstractClassCommandWorking.PrintCommand("foo"));
    Object obj = objectMapper.readValue(
        printSerialized,
        AbstractClassCommandWorking.class);
  }

  @Test
  public void testAbstractClassCommandWorkingToo(ObjectMapper objectMapper) throws IOException {
    String printSerialized = objectMapper.writeValueAsString(new AbstractClassCommandWorkingToo.PrintCommand("foo"));
    Object obj = objectMapper.readValue(
        printSerialized,
        AbstractClassCommandWorkingToo.class);
  }
}

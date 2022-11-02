## Micronaut deserialization of classes implementing a common interface fails

We noticed some very unexpected behaviour when switching from jackson to serde-jackson, resulting in a runtime exception thrown by the serde object mapper.

We are receiving command objects from RabbitMQ that have a common interface and are discerned by a type parameter. The patterns is:

```java
@Serdeable
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, property = "type"
)
interface Command {
    @JsonTypeName("one")
    class CommandOne implements Command {
    ... more properties here
    }

    @JsonTypeName("one")
    class CommandTwo implements Command {        
    ... more properties here
    }
}

@RabbitListener
class CommandListener {
    @Queue("command.queue")
    public void receive(Command command) {
    }
}
```

to deserialize JSON objects of the form

```json
{

    "type": "one",
    ... more properties here
}
```

```json
{

    "type": "two",
    ... more properties here
}
```

We have installed a Serde deser for micronaut.rabbitmq which is working.

Now to the fun part: when the interface has an abstract method that is implemented by the classes, everything works fine. When the interface has a default method that is overriden by the classes, deserialization fails. If the interface has no method at all, deserialization fails. If we use records instead of classes, the deserialization fails.



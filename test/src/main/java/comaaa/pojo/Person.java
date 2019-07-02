package comaaa.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Data
@ConfigurationProperties(prefix = "person")  //
public class Person {
    private String name;
    private int age;
}

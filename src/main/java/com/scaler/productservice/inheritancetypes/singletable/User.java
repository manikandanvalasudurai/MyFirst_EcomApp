package com.scaler.productservice.inheritancetypes.singletable;

import jakarta.persistence.*;

@Entity(name = "st_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_types",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private long id;
    private String name;
    private String email;
}

package com.scaler.productservice.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}

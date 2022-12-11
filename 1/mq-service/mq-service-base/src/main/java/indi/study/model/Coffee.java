package indi.study.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Coffee implements Serializable {

    private String id;

    private String name;

    private BigDecimal price;

}

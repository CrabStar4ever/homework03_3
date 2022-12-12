package indi.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Coffee implements Serializable {
    private static final long serialVersionUID = 193177281500665350L;

    private String id;

    private String name;

    private BigDecimal price;

}

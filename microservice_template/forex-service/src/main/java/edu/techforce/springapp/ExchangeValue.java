package edu.techforce.springapp;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeValue {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigDecimal conversionMultiple;
    private int port;

}

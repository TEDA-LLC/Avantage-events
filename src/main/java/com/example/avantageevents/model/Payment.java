package com.example.avantageevents.model;

import com.example.avantageevents.model.enums.PaymentType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  15:33   *  AvantageEvents
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Payment { //TODO tolovlar

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer paymentNumber;
    private LocalDate paymentDate;
    private Double price;
    private boolean active;
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Order order;
    @ManyToOne
    private Employee receiver;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

}

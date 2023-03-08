package com.example.avantageevents.model;

import com.example.avantageevents.model.enums.RegisteredType;
import com.example.avantageevents.model.enums.RequestType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Malikov Azizjon  *  08.02.2023  *  14:19   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aboutProduct, category;
    private boolean view = false;
    //    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();
    @ManyToOne
    private Product product;
    @Enumerated(EnumType.STRING)
    private RequestType requestStatusType;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private RegisteredType registeredType;
    @ManyToOne
    private Employee employee;
    private LocalDateTime arrivalTime;
    @Column(nullable = true)
    private boolean agree;

}

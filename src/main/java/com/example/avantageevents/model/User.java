package com.example.avantageevents.model;

import com.example.avantageevents.model.enums.Gender;
import com.example.avantageevents.model.enums.Language;
import com.example.avantageevents.model.enums.RegisteredType;
import com.example.avantageevents.model.enums.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  21:44   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username, fullName;
    //    @Column(unique = true)
    private String phone, email;
    //    @Column(unique = true)
    @JsonIgnore
    private String chatId;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private State state;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Gender gender;
    private String passportNumber;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Language language;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Avatar avatar;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Department department;
    //    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Bot bot;
    private int count = 0;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate brithDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registeredTime = LocalDateTime.now();
    @JsonIgnore
    private LocalDateTime lastOperationTime;
    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private List<ActivityStatus> statusList;
    private boolean active = true;
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private RegisteredType registeredType;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    @Column(unique = true)
    private UUID qrcode = UUID.randomUUID();

}

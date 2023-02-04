package com.example.avantageevents.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  19:14   *  AvantageEvents
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ActivityStatus activityType;
    private String stirNumber;
    @ManyToOne
    private Company memberOrganization;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private List<BankInfo> bankInfo;
    @ManyToOne
    private Employee director;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registeredTime = LocalDateTime.now();
    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> clientList;
    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private List<Bot> botList;
    @ManyToMany
    @ToString.Exclude
    private List<Employee> employees;
    @Builder.Default
    private boolean active = true;

    @OneToOne(cascade = CascadeType.ALL)
    private Attachment attachment;

    public Company(Employee director) {
        this.director = director;
    }


    public Company(String name, ActivityStatus activityType, String stirNumber, Address address, Company memberOrganization, List<User> employees, BankInfo bankInfo, Employee director) {
        this.name = name;
        this.activityType = activityType;
        this.stirNumber = stirNumber;
        this.address = address;
        this.memberOrganization = memberOrganization;
//        this.bankInfo = bankInfo;
        this.director = director;
    }

}

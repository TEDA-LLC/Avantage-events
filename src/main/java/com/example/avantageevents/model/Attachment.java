package com.example.avantageevents.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Malikov Azizjon  *  04.02.2023  *  21:49   *  AvantageEvents
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Timestamp timestamp;
    @Column(nullable = false)
    @JsonIgnore
    private byte[] bytes;
    //    @Column(nullable = false)
    private String originalName, contentType;
    private Long size;

}

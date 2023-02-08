package com.example.minor1.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TempModel implements Serializable
{
    @Id
    private int id;

    @Id
    private String name;

    @CreationTimestamp
    private Date createdOn;
}

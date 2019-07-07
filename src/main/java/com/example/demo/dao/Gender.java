package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sarojraj on 6/29/2019.
 */
@Entity
@Table(name = "GENDER")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class Gender extends Audit<String>  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name", nullable = false, unique = true,length = 15)
    private String name;
}

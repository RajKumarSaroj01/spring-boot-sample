package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by sarojraj on 6/17/2019.
 */
@Entity
@Table(name = "EMP")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class EmpEntity extends Audit<String>  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FNAME", nullable = false,length = 30)
    private String fName;

    @Column(name = "LNAME", nullable = true,length = 30)
    private String lName;

    @JoinColumn(name = "GENDER_ID", referencedColumnName = "id", nullable = false,updatable = false)
    @ManyToOne(cascade = CascadeType.DETACH)
    private Gender gender;

    @Column(name = "DOB", nullable = false)
    private Date dob;

    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "id", nullable = false,updatable = false)
    @ManyToOne(cascade = CascadeType.DETACH )
    private Department department;

}

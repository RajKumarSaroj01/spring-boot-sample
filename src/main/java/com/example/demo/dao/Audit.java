package com.example.demo.dao;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by sarojraj on 6/17/2019.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit<U> {
    @CreatedBy
    @Column(name = "CREATED_BY")
    private U createdBy;
    @Column(name = "DATE_CREATED", nullable = false, updatable = false)
    @CreatedDate
    private Date dateCreated;
    @Column(name = "DATE_UPDATED")
    @LastModifiedDate
    private Date dateUpdated;
    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    private U updatedBy;
    public U getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getDateUpdated() {
        return dateUpdated;
    }
    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    public U getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(U updatedBy) {
        this.updatedBy = updatedBy;
    }
}

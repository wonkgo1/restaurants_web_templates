package com.webtemplate.backend.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDomain<E extends BaseDomain<E>> {
    @Column(name = "creat_by_acct_id")
    String createdByAccountId;
    @Column(name = "mod_by_acct_id")
    String modifiedByAccountId;
    @Column(name = "creat_ts")
    Date createdDate;
    @Column(name = "mod_ts")
    Date modifiedDate;

    public String getCreatedByAccountId() {
        return this.createdByAccountId;
    }

    public void setCreatedByAccountId(String createdByAccountId) {
        this.createdByAccountId = createdByAccountId;
    }

    public String getModifiedByAccountId() {
        return this.modifiedByAccountId;
    }

    public void setModifiedByAccountId(String modifiedByAccountId) {
        this.modifiedByAccountId = modifiedByAccountId;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public E createdByAccountId(String createdByAccountId) {
        setCreatedByAccountId(createdByAccountId);
        @SuppressWarnings("unchecked") E that = (E) this;
        return that;
    }

    public E modifiedByAccountId(String modifiedByAccountId) {
        setModifiedByAccountId(modifiedByAccountId);
        @SuppressWarnings("unchecked") E that = (E) this;
        return that;
    }

    public E createdDate(Date createdDate) {
        setCreatedDate(createdDate);
        @SuppressWarnings("unchecked") E that = (E) this;
        return that;
    }

    public E modifiedDate(Date modifiedDate) {
        setModifiedDate(modifiedDate);
        @SuppressWarnings("unchecked") E that = (E) this;
        return that;
    }

}
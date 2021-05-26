package com.webtemplate.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acct")
public class Account extends IdDomain<Account> {
    @Id
    @Column(name = "acct_id")
    String accountId;

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Account accountId(String accountId) {
        setAccountId(accountId);
        return this;
    }

}

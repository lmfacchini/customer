package com.builders.customer.bridge.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CustomerTO implements Serializable {

    @NotNull
    @Size(min = 3, max = 255)
    private String name;


    @NotNull
    @Past
    private Date birth;


    @NotNull
    @Email
    @Size(min = 3, max = 255)
    private String email;

    public CustomerTO() {
    }

    public CustomerTO(String name, Date birth, String email) {
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerTO that = (CustomerTO) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

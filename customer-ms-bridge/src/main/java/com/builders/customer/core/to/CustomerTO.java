package com.builders.customer.core.to;

import com.builders.customer.core.utils.AgeCalculator;

import javax.validation.constraints.*;
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

    @Null
    private AgeTO age;

    public CustomerTO() {
        setBirth(null);
    }

    public CustomerTO(String name, Date birth, String email) {
        this.name = name;
        setBirth(birth);
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
        if(birth != null){
            age = AgeCalculator.calculateAge(birth);
        }else{
            age = new AgeTO((byte)0, (byte)0, (byte)0);
        }
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

    public AgeTO getAge() {
        return age;
    }

}

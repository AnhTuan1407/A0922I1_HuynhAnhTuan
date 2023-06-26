package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Size;

public class Register implements Validator {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Register() {
    }

    public Register(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Register register = (Register) target;
        String firstName = register.getFirstName();
        String lastName = register.getLastName();
        String phoneNumber = register.getPhoneNumber();
        int age = register.getAge();
        String email = register.getEmail();

        // firstName
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
        if (firstName.length() < 5 || firstName.length() > 45) {
            errors.rejectValue("firstName", "firstName.length");
        }

        // lastName
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        if (lastName.length() < 5 || lastName.length() > 45) {
            errors.rejectValue("lastName", "lastName.length");
        }

        // phoneNumber
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }

        if (!phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }

        if (!phoneNumber.matches("^$[(0-9)]*$")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }

        // age
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        if (age < 18){
            errors.rejectValue("age", "age");
        }
    }
}

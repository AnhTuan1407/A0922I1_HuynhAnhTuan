package com.codegym.projectmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "DATE")
    private String dateOfBirth;
    private String address;
    private String phone;
    private String email;
    private String avatar;
    private boolean gender;
    private Boolean delete_flag;
    private Boolean status_join;

    @ManyToOne
    @JoinColumn(name = "group_account_id", referencedColumnName = "id")
    private GroupAccount groupAccount;

    public Student() {
    }

    public Student(Integer id, String name, String dateOfBirth, String address, String phone, String email, String avatar, boolean gender, Boolean delete_flag, Boolean status_join, GroupAccount groupAccount) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
        this.gender = gender;
        this.delete_flag = delete_flag;
        this.status_join = status_join;
        this.groupAccount = groupAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Boolean getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Boolean delete_flag) {
        this.delete_flag = delete_flag;
    }

    public Boolean getStatus_join() {
        return status_join;
    }

    public void setStatus_join(Boolean status_join) {
        this.status_join = status_join;
    }

    public GroupAccount getGroupAccount() {
        return groupAccount;
    }

    public void setGroupAccount(GroupAccount groupAccount) {
        this.groupAccount = groupAccount;
    }
}

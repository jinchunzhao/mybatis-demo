package com.jy.orm.entity;





import java.io.Serializable;
import java.util.Date;


public class Admin implements Serializable {


    private Long id;


    private String userName;

    private String password;

    private String realName;

    private Date birthday;

    private Boolean isEnable;

    private String phone;

    private Integer gender;

    private String email;

    private String avatar;

    private Integer delFlag;






    /**
     * 是否内置
     */
    public enum BuiltIn {
        /**
         * 是
         */
        yes,
        /**
         * 否
         */
        no
    }

    /**
     * 是否启用
     */
    public enum Enable {
        /**
         * 禁用
         */
        no,
        /**
         * 启用
         */
        yes
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", birthday=" + birthday +
                ", isEnable=" + isEnable +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}

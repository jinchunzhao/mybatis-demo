package com.jy.study.mybatis.entity;




import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class Admin  implements Serializable {

    private static final long serialVersionUID = -8944380467491291433L;

    private Long id;


    private String userName;

    private String password;

    private String realName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Boolean isEnable;

    private String phone;

    private String openId;

    private Integer gender;


    private String email;

    private String avatar;

    private Long deptId;

    private Integer isBuiltIn;

    private Integer delFlag;


    private String captcha;//验证码




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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getIsBuiltIn() {
        return isBuiltIn;
    }

    public void setIsBuiltIn(Integer isBuiltIn) {
        this.isBuiltIn = isBuiltIn;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
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
                ", openId='" + openId + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", deptId=" + deptId +
                ", isBuiltIn=" + isBuiltIn +
                ", delFlag=" + delFlag +
                ", captcha='" + captcha + '\'' +
                '}';
    }
}

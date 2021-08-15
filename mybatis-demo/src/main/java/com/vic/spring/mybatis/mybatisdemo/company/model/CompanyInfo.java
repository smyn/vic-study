package com.vic.spring.mybatis.mybatisdemo.company.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vic.spring.mybatis.mybatisdemo.base.mode.BaseModel;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author vic
 * @since 2021-08-15
 */
@TableName("ns_company_info")
public class CompanyInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private String phone;

    private String email;

    private String tag;

    private LocalDateTime intDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public LocalDateTime getIntDate() {
        return intDate;
    }

    public void setIntDate(LocalDateTime intDate) {
        this.intDate = intDate;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
            "name=" + name +
            ", age=" + age +
            ", phone=" + phone +
            ", email=" + email +
            ", tag=" + tag +
            ", intDate=" + intDate +
        "}";
    }
}

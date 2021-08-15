package com.example.spring_boot.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author gubengang
 * @create 2021-08-15 11:39
 */
@Entity
@Data
@Table(name = "tbl_user") // 指定关联的数据库的表名
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "名称不能为空")
    private String name;

    @NotNull
    private Integer age;

    @Size(min=2,max=9)
    private String address;

    @Email
    private String email;
}

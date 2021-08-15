package com.example.spring_boot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @author gubengang
 * @create 2021-08-15 13:23
 */
@Data
@Entity
@Table(name = "tbl_employee") // 指定关联的数据库的表名
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    private String name; // 姓名

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department; // 部门
}

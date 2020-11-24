package com.javakc.pms.dispord.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @description:
 * @create 2020/11/2314:03
 */
@Data
@Entity
@Table(name = "pms_disp_ord")
@EntityListeners(AuditingEntityListener.class)
public class DispOrd {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键")
    private int id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "spec_type")
    private int specType;

    @Column(name = "priority")
    private int priority;

    @Column(name = "order_desc")
    private String orderDesc;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "gmt_create",nullable = false,updatable = false)
    private Date gmtCreate;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "gmt_modified",nullable = false,insertable = false)
    private Date gmtModified;
}

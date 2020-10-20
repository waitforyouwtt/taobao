package com.yidiandian.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by limi on 2017/10/14.
 */
@Data
@Entity
@Table(name = "t_tag")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    /*@ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();*/
}

package com.px.po;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;
    private Integer score;
    private Integer age;
    private Integer gender;
}

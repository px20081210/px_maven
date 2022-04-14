package com.px.immortal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Role {
    /*定义人物特征*/
    private String name;
    private String sex;
    private long age;
    private long life;
    private long mana;
    private int lucky;
    //技能
    //身世
    private String sect;//宗门
    //
}

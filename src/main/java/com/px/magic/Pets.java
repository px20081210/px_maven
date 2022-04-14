package com.px.magic;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Pets extends AllAlf {
	public Pets() {
		super();
	}
	public String trainPets() {//训练宝可梦
		DefineProperties.stardust--;
		int r = new Random().nextInt(4);
		switch(r) {
		case 0:
			aggressivity = aggressivity + new Random().nextInt(10);
			return name+"的攻击力增加了~";
		case 1:
			defense = defense + new Random().nextInt(10);
			return name+"的防御力力增加了~";
		case 2:
			agility = agility + new Random().nextInt(10);
			return name+"的敏捷度增加了~";
		case 3:
			doubleHurtAbility = doubleHurtAbility + new Random().nextInt(5);
			return name+"的暴击率增加了~";
		default:
			sumlife = sumlife + new Random().nextInt(50) + 10;
			return name+"的总生命值增加了";
		}
	}

	
}

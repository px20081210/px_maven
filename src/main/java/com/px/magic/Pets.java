package com.px.magic;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Pets extends AllAlf {
	public Pets() {
		super();
	}
	public String trainPets() {//ѵ��������
		DefineProperties.stardust--;
		int r = new Random().nextInt(4);
		switch(r) {
		case 0:
			aggressivity = aggressivity + new Random().nextInt(10);
			return name+"�Ĺ�����������~";
		case 1:
			defense = defense + new Random().nextInt(10);
			return name+"�ķ�������������~";
		case 2:
			agility = agility + new Random().nextInt(10);
			return name+"�����ݶ�������~";
		case 3:
			doubleHurtAbility = doubleHurtAbility + new Random().nextInt(5);
			return name+"�ı�����������~";
		default:
			sumlife = sumlife + new Random().nextInt(50) + 10;
			return name+"��������ֵ������";
		}
	}

	
}

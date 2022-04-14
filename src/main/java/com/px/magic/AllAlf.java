package com.px.magic;

import java.util.Random;
import java.util.Scanner;

public class AllAlf {//���еľ���
	int propertiesRandom = new Random().nextInt(7);//�����������ȷ������
	int nameRandom = new Random().nextInt(4);//�����������ȷ������
	int kindRandom = new Random().nextInt(7);//���������
	double propertyAddition = 1;//���Լӳ�
	int ex = 0;//����
	int everyLevelEx = 100;
	int elfLevel = 1;//�����εȼ�
	String[] evolutionLevels = {"�������ڡ�","������ڡ�","����ȫ���"}; //����ˮƽ
	String evolutionLevel;
	String name;
	String[] properties = {"��","ˮ","��","��","��","��","��"};
//	String[]names = {"Ƥ����","���ǳ�","�ȱ���","��ɽ��","��β","����","���ٹ�","����","С�Ź�",
//			"С��ʨ","���ױ�","������","ˮ����","�ȱ���","��ɽ��","��β"};
	String[][]primaryLevel = {{"С�����","�����","���ɼ�","������"},{"������","������","ˮԾ��","С����"},{"��������","��·��","�ղ�Ҷ","ľ�ع�"},{"������","Ƥ����","Сè��","����С��"},		{"ʯ����","��������","��żС��","ʼ��С��"},{"����","������","������","ѩ�ҹ�"},{"������","������","������","������"}};//�׶���
	String[][]middleLevel = {{"�ͻ��","��β���","��׳��","������"},{"���","��ϺС��","��Ծ��","����"},{"�����","������","�¹�Ҷ","ɭ������"},{"�׵���","����","�տ�è","������"},			{"������","�����","��ż����","ʼ�����"},{"��ѩ��","��ԭ��","��ħʨ","��ѩ��"},{"�׵���","˫�ױ���","�׿���","������"}};
	String[][]superLevel = {{"�����","������","���漦","����"},{"����","������Ϻ","���ӹ�","������"},{"���ܻ�","������","���ÿ�","������"},{"����žž","???������","����è","����������"},{"���ҹ�","����ϣ��","��ż����","��������"},{"��ѩ����","����ѩ��","������ʨ","������"},{"������ķ","���׶���","������","����"}};
	
	String[][]skillsAll = {{"��������","��������","�����¶�","���ʯ��"},
						{"ˮ��Ծ","��̤","����ˮ��","��ѹˮ��"},
						{"�źŹ���","��������","�ƻ�����","ħ����ҫ"},
						{"���","���","����","ʮ�����"},
						{"�Ϳ���","��ͱ���","����","̩ɽѹ��"},
						{"����","����ȭ","����ѩ","��������"},
						{"��֮ŭ","�����","��������","��Х֮��"}};
	String property;//���������ԣ���ͬ���Կ�ѧϰ��ͬ����
	String[] skills;
	int aggressivity ;//������
	int sumlife;//������ֵ
	int life ;//��ǰ����ֵ
	int defense;//����
	int agility;//���ݶȣ�������ͨ����
	int doubleHurtAbility;//������
	public AllAlf() {
		
		property = properties[propertiesRandom];
		this.skills = skillsAll[kindRandom];
		init();
		life = sumlife;
		infoProperty();
	}
	public void init() {//��ʼ������
		if (DefineProperties.mapdifficulty.equalsIgnoreCase(DefineProperties.mapsdifficulty[0])) {//��ͼ�ѶȲ�ͬ�߼������γ��ָ��ʲ�ͬ
			int rand = new Random().nextInt(20)+1;// 1 2 3 4 5 6 7 8 9 10
			if (rand==1) {
				superElfInit();
			}else if(rand<5) {
				middleElfInit();
			}else {
				primaryElfInit();
			}
		}else if(DefineProperties.mapdifficulty.equalsIgnoreCase(DefineProperties.mapsdifficulty[1])) {
			int rand = new Random().nextInt(20)+1;// 1 2 3 4 5 6 7 8 9 10
			if (rand<2) {
				superElfInit();
			}else if(rand<10) {
				middleElfInit();
			}else {
				primaryElfInit();
			}
		}else if(DefineProperties.mapdifficulty.equalsIgnoreCase(DefineProperties.mapsdifficulty[2])){//�и߼���������
			int rand = new Random().nextInt(20)+1;// 1 2 3 4 5 6 7 8 9 10
			if (rand<5) {
				superElfInit();
			}else if(rand<15) {
				middleElfInit();
			}else {
				primaryElfInit();
			}
		}else {
			int rand = new Random().nextInt(20)+1;// 1 2 3 4 5 6 7 8 9 10
			if (rand<10) {
				superElfInit();
			}else if(rand<20) {
				middleElfInit();
			}else {
				primaryElfInit();
			}
		}
	}
	public void superElfInit() {//�߼����������Գ�ʼ��
		evolutionLevel = evolutionLevels[2];
		name = property+"��"+superLevel[propertiesRandom][nameRandom]+evolutionLevel;
		aggressivity = 1000 + new Random().nextInt(500);
		defense = 500 + new Random().nextInt(300);
		sumlife = 10000 + new Random().nextInt(20000);
		agility = 20 + new Random().nextInt(20);
		doubleHurtAbility =new Random().nextInt(40);
	}
	public void middleElfInit() {//�м������γ�ʼ��
		evolutionLevel = evolutionLevels[1];
		name = middleLevel[kindRandom][nameRandom]+evolutionLevel;
		aggressivity = 500 + new Random().nextInt(500);
		defense = 200 + new Random().nextInt(100);
		sumlife = 5000 + new Random().nextInt(5000);
		agility = 10 + new Random().nextInt(10);
		doubleHurtAbility =new Random().nextInt(30);
	}
	public void primaryElfInit() {//���������γ�ʼ��
		evolutionLevel = evolutionLevels[0];
		name = property+"��"+primaryLevel[kindRandom][nameRandom]+evolutionLevel;
		aggressivity = 100 + new Random().nextInt(100);
		defense = 30 + new Random().nextInt(50);
		sumlife = 1000 + new Random().nextInt(1000);
		agility = new Random().nextInt(20);
		doubleHurtAbility =new Random().nextInt(20);
	}
	public String propertyRestrain(AllAlf enemy) {//�������
		if ("ˮ".equals(this.property)&&"��".equals(enemy.property)) {//ˮ�˻�
		}else if("��".equals(this.property)&&"��".equals(enemy.property)) {//��˲�
		}else if ("��".equals(this.property)&&"ˮ".equals(enemy.property)) {//�ݿ�ˮ
		}else if ("��".equals(this.property)&&"��".equals(enemy.property)) {//�ݿ���
		}else if ("��".equals(this.property)&&"��".equals(enemy.property)) {//�ؿ˵�
		}else if ("��".equals(this.property)&&"ˮ".equals(enemy.property)) {//���ˮ
		}else if ("ˮ".equals(this.property)&&"��".equals(enemy.property)) {//ˮ�˵�
		}else if ("��".equals(this.property)&&"��".equals(enemy.property)) {//������
		}else{
			return this.name+"��"+enemy.name+"֮��û�����Կ���~<br/>";
		}
		propertyAddition = 1.2;//�������Լӳ�Ϊ1.2
		return this.name+this.property+"���Կ���"+enemy.name+"��"+enemy.property+"���ԣ����������������������������ݶȡ������������ٷ�֮20~<br/>";
	}
	public String infoProperty() {//��ӡ����
		return this.name+"������Ϊ��&emsp;"+"<br/>�﹥������"+aggressivity+"&emsp;�������:"+defense+"&emsp;�����ݶȣ�"+agility+"&emsp;�ﱩ���ʣ�"+doubleHurtAbility+"<br/>��������ֵ��"+sumlife+"&emsp;�ﵱǰ����ֵ��"+life+"&emsp;��������ϵ��"+property+"&emsp;��ȼ�"+elfLevel+"<br/>";
	}
	public String infoSkills() {
		StringBuilder enemySkills = new StringBuilder();
		enemySkills.append("ӵ�м��ܣ�<br/>");
		int index = 1;
		for (int i = 0; i < this.skills.length; i++) {
			enemySkills.append((index++)+"."+this.skills[i]);
		}
		return enemySkills.toString();
	}
	public String attack(AllAlf enemy) {//��ͨ����
		StringBuilder sb = new StringBuilder();
		sb.append(propertyRestrain(enemy));
		int r = doubleHurtAbility + new Random().nextInt(100);
		if (r > 100) {
			enemy.life -= this.aggressivity*2*propertyAddition;
			if (enemy.life<0) {
				enemy.life = 0;
			}
			sb.append(this.name + "ʹ����ͨ���������ˡ����һ����Ч�����ԶԷ�"+enemy.name+"�������"+(aggressivity*2*propertyAddition)+"���˺���"+enemy.name +"����ֵʣ�ࣺ"+enemy.life+"<br/>");
			propertyAddition = 1;
			sb.append("<input type='button' value='1' id='button10'/>����");
			return sb.toString();
		}
		enemy.life -= this.aggressivity*propertyAddition;
		if (enemy.life<0) {
			enemy.life = 0;
		}
		sb.append(this.name + "ʹ�á���ͨ������ԶԷ�"+enemy.name+"�����"+aggressivity*propertyAddition+"���˺���"+enemy.name+"����ֵʣ�ࣺ"+enemy.name+"����ֵʣ�ࣺ"+enemy.life+"<br/>");
		propertyAddition = 1;//�ӳ�Ҫ�ָ�����ʼ״̬
		sb.append("<input type='button' value='1' id='button10'/>����");
		return sb.toString();
	}
	public String skillAttack(AllAlf enemy) {//���ܹ���
		StringBuilder sb = new StringBuilder();
		sb.append(infoSkills());
		sb.append(propertyRestrain(enemy));
		sb.append("��ѡ����:<input type='button' value='1' id='button7'/><input type='button' value='2' id='button7'/><input type='button' value='3' id='button7'/><input type='button' value='4' id='button7'/>");
		return sb.toString();
		
		
	}
	public String skillAttack2(AllAlf enemy,int a) {
		a = a-1;
		enemy.life -= this.aggressivity*propertyAddition;
		return this.name +"ʹ�á�"+this.skills[a]+"��ѶԷ�"+enemy.name+"����仨��ˮ��"+enemy.name+"�ܵ���"+(int)(this.aggressivity*propertyAddition*(a+1.5))+"���˺�"+enemy.name +"����ֵʣ�ࣺ"+enemy.life+"<br/><input type='button' value='1' id='button10'/>����";
	}
	public String elfLevelAccount(AllAlf enemy) {//�����������㷨�����齱��
		StringBuilder sb = new StringBuilder();
		if (enemy.evolutionLevel.equals(evolutionLevels[0])) {//����Ǹ������ڵĵ���
			this.ex += 20*enemy.elfLevel;//���˵ȼ�Խ�ߵþ���Խ��
			sb.append("<br/>"+this.name +"�����"+20*enemy.elfLevel+"�ľ��齱��!<br/>");
			if (ex>=everyLevelEx) {
				ex = ex - everyLevelEx;//����ľ���ӵ���һ���ȼ���
				everyLevelEx = (elfLevel++)*100;//���������ܾ�������	
				sb.append(upgrade());
			}
		}else if (enemy.evolutionLevel.equals(evolutionLevels[1])) {
			this.ex += 40*enemy.elfLevel;//���˵ȼ�Խ�ߵþ���Խ��
			sb.append("<br/>"+this.name +"�����"+40*enemy.elfLevel+"�ľ��齱��");
			if (ex>=everyLevelEx) {
				ex = ex - everyLevelEx;//����ľ���ӵ���һ���ȼ���
				everyLevelEx = (elfLevel++)*100;//���������ܾ�������	
				sb.append(upgrade());
			}
		}else if (enemy.evolutionLevel.equals(evolutionLevels[2])) {
			this.ex += 80*enemy.elfLevel;//���˵ȼ�Խ�ߵþ���Խ��
			sb.append("<br/>"+this.name +"�����"+80*enemy.elfLevel+"�ľ��齱��");
			if (ex>=everyLevelEx) {
				ex = ex - everyLevelEx;//����ľ���ӵ���һ���ȼ���
				everyLevelEx = (elfLevel++)*100;//���������ܾ�������	
				sb.append(upgrade());
			}
		}
		return sb.append("<br/>").toString();
	}
	public String upgrade() {//��������
		this.infoProperty();
		aggressivity += aggressivity*0.1;//������
		sumlife += sumlife*0.1;//������ֵ
		life = sumlife;//��ǰ����ֵ
		defense += defense*0.1;//����
		agility += agility*0.1;//���ݶȣ�������ͨ����
		doubleHurtAbility += doubleHurtAbility*0.1;//������
		return this.name+"������~���Ը�����õ��˼�ǿ~~";
	}
	
	
	
	
	
	
	
}

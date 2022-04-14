package com.px.magic;

import java.util.Random;
import java.util.Scanner;

public class AllAlf {//所有的精灵
	int propertiesRandom = new Random().nextInt(7);//属性随机数，确定属性
	int nameRandom = new Random().nextInt(4);//名字随机数，确定名字
	int kindRandom = new Random().nextInt(7);//种类随机数
	double propertyAddition = 1;//属性加成
	int ex = 0;//经验
	int everyLevelEx = 100;
	int elfLevel = 1;//宝可梦等级
	String[] evolutionLevels = {"★幼年期★","★成熟期★","★完全体★"}; //进化水平
	String evolutionLevel;
	String name;
	String[] properties = {"火","水","草","电","地","冰","龙"};
//	String[]names = {"皮卡丘","独角虫","比比鸟","穿山鼠","九尾","地鼠","风速狗","怪力","小磁怪",
//			"小海狮","铁甲贝","大岩蛇","水箭龟","比比鸟","穿山鼠","九尾"};
	String[][]primaryLevel = {{"小火焰猴","火狐狸","火稚鸡","火球鼠"},{"利牙鱼","鲶鱼王","水跃鱼","小巨鳄"},{"妙蛙种子","走路草","菊草叶","木守宫"},{"落雷兽","皮卡丘","小猫怪","麻麻小鱼"},		{"石丸子","宝宝暴龙","泥偶小人","始祖小鸟"},{"冰宝","喷嚏熊","海豹球","雪笠怪"},{"龙卷云","单首龙","宝贝龙","迷你龙"}};//幼儿期
	String[][]middleLevel = {{"猛火猴","长尾火狐","力壮鸡","火焰鼠"},{"吼吼鲸","龙虾小兵","沼跃鱼","蓝鳄"},{"妙草蛙","臭臭花","月桂叶","森林蜥蜴"},{"雷电兽","雷丘","勒克猫","麻麻鳗"},			{"地蔓岩","怪颚龙","泥偶巨人","始祖大鸟"},{"冰雪龙","冻原熊","海魔狮","暴雪王"},{"雷电云","双首暴龙","甲壳龙","哈克龙"}};
	String[][]superLevel = {{"烈焰猴","妖火红狐","火焰鸡","火爆兽"},{"吼鲸王","铁螯龙虾","巨沼怪","大力鳄"},{"妙蛙花","霸王花","大竺葵","蜥蜴王"},{"正电啪啪","???丘丘丘","伦琴猫","麻麻鳗鱼王"},{"庞岩怪","古拉希尔","泥偶巨龙","鲲鹏神鸟"},{"冰雪巨龙","几何雪花","帝牙海狮","玛狃拉"},{"莱西拉姆","三首恶龙","暴飞龙","快龙"}};
	
	String[][]skillsAll = {{"火焰喷射","高速星星","极限温度","电光石火"},
						{"水溅跃","践踏","喷射水柱","高压水泵"},
						{"信号光线","急冻光线","破坏光线","魔法照耀"},
						{"电光","电击","打雷","十万伏特"},
						{"低空钻","泥巴爆弹","地震","泰山压顶"},
						{"冻风","急冻拳","暴风雪","急冻光线"},
						{"龙之怒","龙卷风","月亮攻击","龙啸之音"}};
	String property;//宝可梦属性，不同属性可学习不同技能
	String[] skills;
	int aggressivity ;//攻击力
	int sumlife;//总生命值
	int life ;//当前生命值
	int defense;//防御
	int agility;//敏捷度，闪避普通攻击
	int doubleHurtAbility;//暴击率
	public AllAlf() {
		
		property = properties[propertiesRandom];
		this.skills = skillsAll[kindRandom];
		init();
		life = sumlife;
		infoProperty();
	}
	public void init() {//初始化属性
		if (DefineProperties.mapdifficulty.equalsIgnoreCase(DefineProperties.mapsdifficulty[0])) {//地图难度不同高级宝可梦出现概率不同
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
		}else if(DefineProperties.mapdifficulty.equalsIgnoreCase(DefineProperties.mapsdifficulty[2])){//中高级概率增加
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
	public void superElfInit() {//高级宝可梦属性初始化
		evolutionLevel = evolutionLevels[2];
		name = property+"·"+superLevel[propertiesRandom][nameRandom]+evolutionLevel;
		aggressivity = 1000 + new Random().nextInt(500);
		defense = 500 + new Random().nextInt(300);
		sumlife = 10000 + new Random().nextInt(20000);
		agility = 20 + new Random().nextInt(20);
		doubleHurtAbility =new Random().nextInt(40);
	}
	public void middleElfInit() {//中级宝可梦初始化
		evolutionLevel = evolutionLevels[1];
		name = middleLevel[kindRandom][nameRandom]+evolutionLevel;
		aggressivity = 500 + new Random().nextInt(500);
		defense = 200 + new Random().nextInt(100);
		sumlife = 5000 + new Random().nextInt(5000);
		agility = 10 + new Random().nextInt(10);
		doubleHurtAbility =new Random().nextInt(30);
	}
	public void primaryElfInit() {//初级宝可梦初始化
		evolutionLevel = evolutionLevels[0];
		name = property+"·"+primaryLevel[kindRandom][nameRandom]+evolutionLevel;
		aggressivity = 100 + new Random().nextInt(100);
		defense = 30 + new Random().nextInt(50);
		sumlife = 1000 + new Random().nextInt(1000);
		agility = new Random().nextInt(20);
		doubleHurtAbility =new Random().nextInt(20);
	}
	public String propertyRestrain(AllAlf enemy) {//属性相克
		if ("水".equals(this.property)&&"火".equals(enemy.property)) {//水克火
		}else if("火".equals(this.property)&&"草".equals(enemy.property)) {//火克草
		}else if ("草".equals(this.property)&&"水".equals(enemy.property)) {//草克水
		}else if ("草".equals(this.property)&&"地".equals(enemy.property)) {//草克土
		}else if ("地".equals(this.property)&&"电".equals(enemy.property)) {//地克电
		}else if ("电".equals(this.property)&&"水".equals(enemy.property)) {//电克水
		}else if ("水".equals(this.property)&&"地".equals(enemy.property)) {//水克地
		}else if ("冰".equals(this.property)&&"龙".equals(enemy.property)) {//冰克龙
		}else{
			return this.name+"与"+enemy.name+"之间没有属性克制~<br/>";
		}
		propertyAddition = 1.2;//克制属性加成为1.2
		return this.name+this.property+"属性克制"+enemy.name+"的"+enemy.property+"属性，气势上升，增加自身攻击力、敏捷度、暴击率提升百分之20~<br/>";
	}
	public String infoProperty() {//打印属性
		return this.name+"的属性为：&emsp;"+"<br/>★攻击力："+aggressivity+"&emsp;★防御力:"+defense+"&emsp;★敏捷度："+agility+"&emsp;★暴击率："+doubleHurtAbility+"<br/>★总生命值："+sumlife+"&emsp;★当前生命值："+life+"&emsp;★所属体系："+property+"&emsp;★等级"+elfLevel+"<br/>";
	}
	public String infoSkills() {
		StringBuilder enemySkills = new StringBuilder();
		enemySkills.append("拥有技能：<br/>");
		int index = 1;
		for (int i = 0; i < this.skills.length; i++) {
			enemySkills.append((index++)+"."+this.skills[i]);
		}
		return enemySkills.toString();
	}
	public String attack(AllAlf enemy) {//普通攻击
		StringBuilder sb = new StringBuilder();
		sb.append(propertyRestrain(enemy));
		int r = doubleHurtAbility + new Random().nextInt(100);
		if (r > 100) {
			enemy.life -= this.aggressivity*2*propertyAddition;
			if (enemy.life<0) {
				enemy.life = 0;
			}
			sb.append(this.name + "使用普通攻击产生了★会心一击★效果，对对方"+enemy.name+"，造成了"+(aggressivity*2*propertyAddition)+"点伤害！"+enemy.name +"生命值剩余："+enemy.life+"<br/>");
			propertyAddition = 1;
			sb.append("<input type='button' value='1' id='button10'/>继续");
			return sb.toString();
		}
		enemy.life -= this.aggressivity*propertyAddition;
		if (enemy.life<0) {
			enemy.life = 0;
		}
		sb.append(this.name + "使用★普通攻击★对对方"+enemy.name+"造成了"+aggressivity*propertyAddition+"点伤害！"+enemy.name+"生命值剩余："+enemy.name+"生命值剩余："+enemy.life+"<br/>");
		propertyAddition = 1;//加成要恢复到初始状态
		sb.append("<input type='button' value='1' id='button10'/>继续");
		return sb.toString();
	}
	public String skillAttack(AllAlf enemy) {//技能攻击
		StringBuilder sb = new StringBuilder();
		sb.append(infoSkills());
		sb.append(propertyRestrain(enemy));
		sb.append("请选择技能:<input type='button' value='1' id='button7'/><input type='button' value='2' id='button7'/><input type='button' value='3' id='button7'/><input type='button' value='4' id='button7'/>");
		return sb.toString();
		
		
	}
	public String skillAttack2(AllAlf enemy,int a) {
		a = a-1;
		enemy.life -= this.aggressivity*propertyAddition;
		return this.name +"使用★"+this.skills[a]+"★把对方"+enemy.name+"打的落花流水！"+enemy.name+"受到了"+(int)(this.aggressivity*propertyAddition*(a+1.5))+"点伤害"+enemy.name +"生命值剩余："+enemy.life+"<br/><input type='button' value='1' id='button10'/>继续";
	}
	public String elfLevelAccount(AllAlf enemy) {//宝可梦升级算法及经验奖励
		StringBuilder sb = new StringBuilder();
		if (enemy.evolutionLevel.equals(evolutionLevels[0])) {//如果是个幼年期的敌人
			this.ex += 20*enemy.elfLevel;//敌人等级越高得经验越多
			sb.append("<br/>"+this.name +"获得了"+20*enemy.elfLevel+"的经验奖励!<br/>");
			if (ex>=everyLevelEx) {
				ex = ex - everyLevelEx;//溢出的经验加到下一个等级上
				everyLevelEx = (elfLevel++)*100;//升级所需总经验提升	
				sb.append(upgrade());
			}
		}else if (enemy.evolutionLevel.equals(evolutionLevels[1])) {
			this.ex += 40*enemy.elfLevel;//敌人等级越高得经验越多
			sb.append("<br/>"+this.name +"获得了"+40*enemy.elfLevel+"的经验奖励");
			if (ex>=everyLevelEx) {
				ex = ex - everyLevelEx;//溢出的经验加到下一个等级上
				everyLevelEx = (elfLevel++)*100;//升级所需总经验提升	
				sb.append(upgrade());
			}
		}else if (enemy.evolutionLevel.equals(evolutionLevels[2])) {
			this.ex += 80*enemy.elfLevel;//敌人等级越高得经验越多
			sb.append("<br/>"+this.name +"获得了"+80*enemy.elfLevel+"的经验奖励");
			if (ex>=everyLevelEx) {
				ex = ex - everyLevelEx;//溢出的经验加到下一个等级上
				everyLevelEx = (elfLevel++)*100;//升级所需总经验提升	
				sb.append(upgrade());
			}
		}
		return sb.append("<br/>").toString();
	}
	public String upgrade() {//升级功能
		this.infoProperty();
		aggressivity += aggressivity*0.1;//攻击力
		sumlife += sumlife*0.1;//总生命值
		life = sumlife;//当前生命值
		defense += defense*0.1;//防御
		agility += agility*0.1;//敏捷度，闪避普通攻击
		doubleHurtAbility += doubleHurtAbility*0.1;//暴击率
		return this.name+"升级了~属性各方面得到了加强~~";
	}
	
	
	
	
	
	
	
}

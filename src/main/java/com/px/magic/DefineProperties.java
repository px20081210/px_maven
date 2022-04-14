package com.px.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DefineProperties {
	public static String[] mapsdifficulty = { "真新镇", "神奥地区", "卡洛斯地区", "阿罗拉地区" };
	public static String mapdifficulty = mapsdifficulty[0];// 关卡难度//真新镇、枯叶市、紫苑镇、红莲岛、丰缘地区、神奥地区、卡洛斯地区、阿罗拉地区、七之岛、
	public static int superMedicine = 1;
	public static int medicine = 3;
	public static int stardust = 2; // 星尘，用于强化
	public static int elfBall = 10;// 用于捕捉精灵
	public static int superElfBall = 5;// 大概率捕捉到精灵
	public static List<Pets> pets = new ArrayList<Pets>();
	Pets enemy = new Pets();

	public void info() {// 查询道具
		System.out.println("1.初级治疗丸：" + DefineProperties.medicine + "    2.高级治疗丸:" + DefineProperties.superMedicine
				+ "    3.星尘：" + DefineProperties.stardust + "    4.普通精灵球：" + DefineProperties.elfBall + "    5.高级精灵球："
				+ DefineProperties.superElfBall);
	}

	public void checkPetsState() {// 查看宝可梦状态
		while (true) {
			int index = 1;
			System.out.println("选择要查看的宝可梦");
			System.out.println("--------------------------------------------------------------");
			for (Pets p : pets) {
				System.out.print("※" + (index++) + "." + p.name);
			}
			System.out.println();
			System.out.println("--------------------------------------------------------------");
			int scan = new Scanner(System.in).nextInt() - 1;
			if (scan < 0 || scan >= pets.size()) {
				System.out.println("请重新选择>>");
				continue;
			}
			pets.get(scan).infoProperty();
			new Scanner(System.in).nextLine();
			break;
		}
	}

	public static void mapChange() {// 地图选择
		System.out.println("====================================================================");
		System.out.println("※下面是地图选项：");
		System.out.println("※1." + DefineProperties.mapsdifficulty[0] + "(建议新手在此发育)" + "    2."
				+ DefineProperties.mapsdifficulty[1] + "(逐渐会遇得更稀有的宝可梦，但难度也大大增加！)" + "\n※3."
				+ DefineProperties.mapsdifficulty[2] + "(此地图会出现大量高级宝可梦，注意安全！)" + "    4."
				+ DefineProperties.mapsdifficulty[3] + "(噩梦地区，慎入！！！)");
		System.out.print("※请选择地图>>");
		int scan = new Scanner(System.in).nextInt() - 1;
		int maxLevel = 1;
		for (int i = 0; i < DefineProperties.pets.size(); i++) {
			if (DefineProperties.pets.get(i).elfLevel > maxLevel) {// 找出最高等级
				maxLevel = DefineProperties.pets.get(i).elfLevel;
			}
		}
		if (scan < 0 || scan > 3) {// 输入的2,第二地图限制宝可梦等级5
			System.out.println("※没有正确选择地图！！");
			return;
		}
		if (scan == 1 && maxLevel < 5) {
			System.out.println("※您的宝可梦还没有达到5级，还要加油升级哦~");
			return;
		} else if (scan == 2 && maxLevel < 10) {
			System.out.println("※您的宝可梦还没有达到10级，还要加油升级哦~");
			return;
		} else if (scan == 3 && maxLevel < 20) {
			System.out.println("※您的宝可梦还没有达到20级，还要加油升级哦~");
			return;
		}
		DefineProperties.mapdifficulty = DefineProperties.mapsdifficulty[scan];
		System.out.println("※欢迎来到" + DefineProperties.mapdifficulty + "!!");
	}

	// 奖励程序
	public String award() {
		int rand = new Random().nextInt(12) + 1;// 1~12
		if (rand <= 3) {
			DefineProperties.medicine += rand;
			return "★获得初级治疗丸" + rand + "颗";
		} else if (rand <= 6) {
			DefineProperties.superMedicine += rand - 4;
			return "★获得高级治疗丸" + (rand - 3) + "颗";
		} else if (rand == 7) {
			DefineProperties.stardust += 1;
			return "★获得星尘1颗（用于强化）";
		} else if (rand <= 10) {
			DefineProperties.elfBall += rand - 6;
			return "★获得精灵球" + (rand - 6) + "个";
		} else  {
			DefineProperties.superElfBall += rand - 10;
			return "★获得高级精灵球" + (rand - 10) + "个";
		}
	}

	// 加载界面
	public static void loadFrame() {
		System.out.print("加载中");
		for (int i = 0; i < 20; i++) {
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(">>>");
		}
		System.out.println();
	}

	// 选择宝可梦界面
	public String decideElf() {
		int index = 1;
		StringBuilder elfList = new StringBuilder();
		elfList.append("<font color='skyblue' size='10px'>请选择宝可梦:</font><br/>");
		for (Pets p : DefineProperties.pets) {
			// button2 选择宝可梦的按钮
			elfList.append("<input type='button' value='" + (index++) + "'  id='button2' />" + p.name);
		}
		return elfList.toString();
	}

	public static String actionPets(int a, int s) {// 强化和治疗
		s = s - 1;// 集合下标从0开始
		if (a == 1) {// 治疗宝可梦
			medicine--;
			pets.get(s).life += pets.get(s).life + pets.get(s).sumlife / 4;// 回复生命值百分比
			if (pets.get(s).life > pets.get(s).sumlife) {
				pets.get(s).life = pets.get(s).sumlife;
			}
			return "宝可梦受到治疗了，生命值回复为：" + pets.get(s).life;
		} else if (a == 2) {// 治疗宝可梦
			superMedicine--;
			pets.get(s).life += pets.get(s).life + pets.get(s).sumlife / 2;// 回复生命值百分比
			if (pets.get(s).life > pets.get(s).sumlife) {
				pets.get(s).life = pets.get(s).sumlife;
			}
			return "宝可梦受到治疗了，生命值回复为：" + pets.get(s).life;
		} else if (a == 3) {// 训练宝可梦
			return pets.get(s).trainPets();
		} else {
			return "精灵球不能在此场合使用！";
		}

	}

	public String decideBall() {
		return "选择捕捉道具：<input type='button' value='1' id='button4'/>普通精灵球<input type='button' value='2' id='button4'/>高级精灵球";
	}

	public String arrest(int a) {// 捕获宝可梦界面
		StringBuilder sb = new StringBuilder();
		if (a == 1) {
			DefineProperties.elfBall--;
			int rand = new Random().nextInt(100);
			sb.append("正在使用★普通精灵球★捕捉宝可梦~~~~~~~~~~~~~~~~~~~~~~~~~<br/><br/>");
			int s = enemy.evolutionLevels.toString().indexOf(enemy.evolutionLevel);
			if (rand >= (60 + s * 20)) {
				sb.append("恭喜你成功捕捉宝可梦！sss");
				pets.add(enemy);
			} else {
				sb.append("就差一点点~<br/>是否继续捕捉?<br/><input type='button' value='1' id='button5'/>是<br/><input type='button' value='2' id='button5'/>否");
			}
			return sb.toString();
		} else {
			superElfBall--;
			int rand = new Random().nextInt(100);
			sb.append("正在使用★高级精灵球★捕捉宝可梦~~~~~~~~~~~~~~~~~~~~~~~~~<br/>");
			// 增加高级宝可梦的捕获难度
			int s = enemy.evolutionLevels.toString().indexOf(enemy.evolutionLevel);
			if (rand >= (30 + s * 20)) {
				sb.append("恭喜你成功捕捉宝可梦！sss");
				pets.add(enemy);
			} else {
				sb.append(
						"就差一点点~<br/>是否继续捕捉?<br/><input type='button' value='1' id='button5'/>是&emsp;<input type='button' value='1' id='button5'/>否");
			}
			return sb.toString();
		}
	}

	public String walk() {// 主角移动★
		int rand = new Random().nextInt(6);// 0 1 2 3 4
		if (rand == 0) {
			return "★这里是一片草丛，什么也没有~★";
		} else if (rand == 1) {
			award();
			return "★在路边发现了一件神秘物品~正在打开~★<br/>"+award();
		} else if (rand == 2) {
			return "★这个地洞里似乎有什么可怕的东西，赶紧溜溜球~★";
		} else if (rand == 3) {
			return "★。。。什么也没有发生~★";
		} else {
			enemy = new Pets();
			String enemySkills = enemy.infoSkills();
			return "★遇到了一只野生的宝可梦★<br/>" + enemySkills+enemy.infoProperty()
					+ "★请选择>><input type='button' value='1' id='button3'/>战斗<input type='button' value='2' id='button3'/>捕捉<input type='button' value='3' id='button3'/>逃跑";
		}
	}

	public String decideAction(int a) {
		if (a == 1) {
			return decideElf();// 选择战斗精灵
		} else if (a == 2) {
			return decideBall();
		} else {
			return "你落花流水地逃跑了！";
		}
	}

	public String consumablesFrames() {// 消耗品界面
		return "<font color='green' size='5px'>" + "您用的道具有: <br/>"
				+ "<input type='button' value='1' id='button1'/>初级治疗丸:" + medicine
				+ "&emsp;<input type='button' value='2'  id='button1' />高级治疗丸:" + superMedicine
				+ "&emsp;<input type='button' value='3' id='button1'/>星尘:" + stardust
				+ "&emsp;<input type='button' value='4' id='button1'/>普通精灵球：" + elfBall
				+ "&emsp;<input type='button' value='5' id='button1'/>高级精灵球:" + DefineProperties.superElfBall
				+ "<br/>请选择>></font>";
	}

	public String attackFrames(int s) {// 出场战斗界面
		StringBuilder sb = new StringBuilder();
		s = s-1;
		sb.append("★" + pets.get(s).name + "闪亮登场！★<br/>");
		sb.append(pets.get(s).infoProperty());
		sb.append("★现在是你的宝可梦" + pets.get(s).name + "的回合！<br/>");
		sb.append("★功能菜单：<input type='button' value='1' id='button6' class='attackButton'/>普通攻击&emsp;&emsp;<input type='button' value='2' id='button6'/>技能攻击<br/><input type='button' value='3' id='button6'/>更换宝可梦&emsp;&emsp;<input type='button' value='4' id='button6'/>道具箱");
		return sb.toString();
	}
	public String attackFrames3(int s) {// 继续战斗战斗界面
		StringBuilder sb = new StringBuilder();
		s = s-1;
		sb.append(pets.get(s).infoProperty());
		sb.append("★现在又到了你的宝可梦" + pets.get(s).name + "的回合！<br/>");
		sb.append("★功能菜单：<input type='button' value='1' id='button6' class='attackButton'/>普通攻击&emsp;&emsp;<input type='button' value='2' id='button6'/>技能攻击<br/><input type='button' value='3' id='button6'/>更换宝可梦&emsp;&emsp;<input type='button' value='4' id='button6'/>道具箱");
		return sb.toString();
	}
	public String skillAttack3(int a,int s) {//选择了技能然后调用方法
		s = s - 1;
		return pets.get(s).skillAttack2(enemy,a);
	}
	public String attackFrame2(int a,int s) {// 选择攻击技能道具
		s = s - 1;
		if (a == 1) {
			return pets.get(s).attack(enemy);
		} else if (a == 2) {
			return pets.get(s).skillAttack(enemy);// 这个方法内要选择技能,所以直接返回
		} else if (a == 3) {
			return "";
		} else if (a == 4) {
			consumablesFrames();
			return "";
		} else {
			return "★哎呀，手滑了！";
		}
		
	}
	public String enemyAttack(int s) {
		s = s-1;
		StringBuilder sb = new StringBuilder();
		if (enemy.life <= 0) {
			sb.append("★" + enemy.name + "被打败了！<br/>") ;
			sb.append(award());// 编写奖励代码
			sb.append(pets.get(s).elfLevelAccount(enemy));// 经验奖励
			sb.append("<input type='button' value='1' id='button11'/>离开(显示移动面板)");
			return sb.toString();
		}
		sb.append("★轮到野生宝可梦" + enemy.name + "攻击了！<br/>");
		sb.append(enemy.attack(DefineProperties.pets.get(s)));
		if (pets.get(s).life == 0) {
			sb.delete(sb.length() - 49, sb.length()-1);
			sb.append("★" + pets.get(s).name + "被打败了！请选择><input type='button' value='1' id='button8'/>更换宝可梦&emsp;&emsp;<input type='button' value='2' id='button8'/>逃跑");
		}else {
			sb.append("让对方进攻<input type='button' value='1' id='button9'/>继续&emsp;<input type='button' value='2' id='button9'/>逃跑");
		}
		return sb.toString();
	}

//	public static void run() {
//		while (true) {
//			System.out.println("=====================================================================");
//			System.out.println("※tips：输入S可查看你的道具箱~输入D查看宝可梦状态~回车键前行~M查看选择地图~");
//			System.out.println("=====================================================================");
//
//			String scan = new Scanner(System.in).nextLine();
//			if ("s".equalsIgnoreCase(scan)) {
//				DefineProperties.consumablesFrames();
//				continue;
//			}
//			if ("d".equalsIgnoreCase(scan)) {
//				DefineProperties.checkPetsState();
//				continue;
//			}
//			if ("m".equalsIgnoreCase(scan)) {
//				DefineProperties.mapChange();
//				continue;
//			}
//			DefineProperties.walk();
//
//		}
//	}

	public String[] getMapsdifficulty() {
		return mapsdifficulty;
	}

	public void setMapsdifficulty(String[] mapsdifficulty) {
		DefineProperties.mapsdifficulty = mapsdifficulty;
	}

	public String getMapdifficulty() {
		return mapdifficulty;
	}

	public void setMapdifficulty(String mapdifficulty) {
		DefineProperties.mapdifficulty = mapdifficulty;
	}

	public int getSuperMedicine() {
		return superMedicine;
	}

	public void setSuperMedicine(int superMedicine) {
		DefineProperties.superMedicine = superMedicine;
	}

	public int getMedicine() {
		return medicine;
	}

	public void setMedicine(int medicine) {
		DefineProperties.medicine = medicine;
	}

	public int getStardust() {
		return stardust;
	}

	public void setStardust(int stardust) {
		DefineProperties.stardust = stardust;
	}

	public int getElfBall() {
		return elfBall;
	}

	public void setElfBall(int elfBall) {
		DefineProperties.elfBall = elfBall;
	}

	public int getSuperElfBall() {
		return superElfBall;
	}

	public void setSuperElfBall(int superElfBall) {
		DefineProperties.superElfBall = superElfBall;
	}

	public List<Pets> getPets() {
		return pets;
	}

	public void setPets(List<Pets> pets) {
		DefineProperties.pets = pets;
	}

}

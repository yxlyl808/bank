package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Mulu extends JFrame implements ActionListener{ //ActionListener接口是动作事件监听器
	JButton a1,a2,a3,a4,a5; //创建按钮
	JLabel b1,b2; //创建标签
	
	public Mulu() 
	{
		b1=new JLabel("欢迎使用武汉轻工银行"); //标签初始化
		b1.setFont(new java.awt.Font("微软雅黑",1,37)); //设置标签的字体类型，加粗，字号大小
		b2=new JLabel("ATM机");
		b2.setFont(new java.awt.Font("微软雅黑",1,37));
		a1=new JButton("查询余额"); //按钮初始化
		a2=new JButton("存款");
		a3=new JButton("取款");
		a4=new JButton("修改密码");
		a5=new JButton("退出");
		this.setTitle("ATM柜员机系统"); //界面初始化
		this.setSize(600,825); //界面大小
		this.setLayout(null); //不使用默认布局
		this.setLocationRelativeTo(null);//在屏幕中间居中显示
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //关闭界面后程序停止运行
	    this.setVisible(true); //界面可见
	    b1.setBounds(120,15,450,75); //设置标签的位置和大小
	    b2.setBounds(230,80,250,75);
		a1.setBounds(180,200,225,75); //设置按钮的位置和大小
		a2.setBounds(180,305,225,75);
		a3.setBounds(180,410,225,75);
		a4.setBounds(180,515,225,75);
		a5.setBounds(180,620,225,75);
		this.add(b1); //加入到界面中
		this.add(b2);
		this.add(a1);
		this.add(a2);
		this.add(a3);
		this.add(a4);
		this.add(a5);
		a1.addActionListener(this); //动作事件监听
		a2.addActionListener(this);
		a3.addActionListener(this);
		a4.addActionListener(this);
		a5.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){ //重写监听器接口里的方法
		if(e.getActionCommand()=="退出" ) //按钮被按下，触发事件
		{
			System.exit(0); //程序结束 
		}
		else //按下其它按钮
		{
			new Denglu(e.getActionCommand()); //跳转到登录界面
		}
	}
	
}

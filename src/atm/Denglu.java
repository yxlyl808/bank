package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Denglu extends JFrame implements ActionListener{ //登录
	JButton a1; //创建按钮
	JLabel b1,b2; //创建标签
	JTextField d1; //创建文本框
	JPasswordField e1; //创建密码框
	String s; //传入
	
	public Denglu(String s) {
		this.s=s;
		a1=new JButton("登录"); //按钮
		b1=new JLabel("卡 号："); //标签
		b2=new JLabel("密 码：");
		d1=new JTextField(15); //文本框和密码框
		e1=new JPasswordField(15);
		this.setTitle("登录"); //界面初始化
		this.setSize(450,300); //界面大小
		this.setLayout(null); //不使用默认布局
		this.setLocationRelativeTo(null); //在屏幕中间居中显示
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置仅关闭当前界面
	    this.setVisible(true); //界面可见
	    b1.setBounds(90,30,60,45); //设置标签的位置和大小
	    b2.setBounds(90,90,60,45);
		a1.setBounds(150,165,150,60); //设置按钮的位置和大小
		d1.setBounds(150,30,225,45); //设置文本框和密码框的位置和大小
		e1.setBounds(150,90,225,45);
		this.add(b1); //加入到界面中
		this.add(b2);
		this.add(a1);
		this.add(d1);
		this.add(e1);
		a1.addActionListener(this); //动作事件监听
	}

	public void actionPerformed(ActionEvent e){ //重写监听器接口里的方法
		if(e.getActionCommand()=="登录")
		{
			try {
				tiaozhuan();
			} catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}

	public void tiaozhuan() throws IOException{ //登录成功后跳转
		String s1=String.valueOf(e1.getPassword());
		if(yanzheng(d1.getText(),s1))
		{
			JOptionPane.showMessageDialog(null,"登录成功！"); //弹出警告
			if(s.equals("查询余额"))
			{
				new Chaxun(d1.getText()); //跳转到查询界面
			}
			if(s.equals("存款"))
			{
				new Cunqian(d1.getText()); //跳转到存款界面
			}
			if(s.equals("取款"))
			{
				new Quqian(d1.getText()); //跳转到取款界面
			}
			if(s.equals("修改密码"))
			{
				new Gaimi(d1.getText()); //跳转到改密界面
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"账号或密码错误，请重新输入！");
		}
	}
	
    public boolean yanzheng(String ming,String mima) throws IOException{ //验证账号密码是否正确
    	String []xinxi=new Duxie().du(ming); //读的信息传入字符串数组中
		if(xinxi[0].equals(ming)&&xinxi[1].equals(mima))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}


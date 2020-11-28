package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cunqian extends JFrame implements ActionListener{ //存钱
	JButton a1; //创建按钮
	JLabel b1; //创建标签
	JTextField d1,d2,d3; //创建文本框
	String ming; //传入
	
	public Cunqian(String ming){
		this.ming=ming;
		a1=new JButton("确定"); //按钮
		b1=new JLabel("请输入存款金额："); //标签
		d1=new JTextField(); //文本框
		d2=new JTextField();
		d3=new JTextField();
		this.setTitle("存钱"); //界面初始化
		this.setSize(450,390); //界面大小
		this.setLayout(null); //不使用默认布局
		this.setLocationRelativeTo(null); //在屏幕中间居中显示
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置仅关闭当前界面
	    this.setVisible(true); //界面可见
	    b1.setBounds(30,30,195,45); //设置标签的位置和大小
		a1.setBounds(150,105,150,60); //设置按钮的位置和大小
		d1.setBounds(195,30,225,45); //设置文本框的位置和大小
		d2.setBounds(30,180,375,60);
		d3.setBounds(30,240,375,60);
		this.add(b1); //加入到界面中
		this.add(a1);
		this.add(d1);
		this.add(d2);
		this.add(d3);
		a1.addActionListener(this); //按钮监听
	}
	
	public void actionPerformed(ActionEvent e){ //重写监听器接口里的方法
		if (e.getActionCommand()=="确定")
		{
			try {
				cun();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void cun() throws IOException{ //显示存入
		if (d1.getText().isEmpty()) //存款金额不能空
		{
			JOptionPane.showMessageDialog(null,"存款金额不能为空！");
		}
		else if(yanzheng(d1.getText()))
		{
			String []xinxi=new Duxie().du(ming); //读的信息传入字符串数组中
			int a=Integer.parseInt(xinxi[2])+Integer.parseInt(d1.getText()); //转int
			xinxi[2]=String.valueOf(a); //转string
			new Duxie().xie(xinxi); //写入文件
			d2.setText("存入金额为:\n "+d1.getText()); //显示
			d3.setText("现有余额为:\n "+xinxi[2]);
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"输入错误，重新输入!");
		}
	}
	
	public boolean yanzheng(String qian){ //验证存入金额是否正确
		for(int i=0;i<qian.length();i++) //逐位判断是否为数字
		{
			if (qian.charAt(i)<'0'||qian.charAt(i)>'9')
				return false;
		}  
		return true;
	}
}

package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Chaxun extends JFrame implements ActionListener{ //查询
	JLabel b1,b2; //创建标签
	JTextField d1,d2; //创建文本框
	
	public Chaxun(String ming) throws IOException{
		b1=new JLabel("账号："); //标签
		b2=new JLabel("余额：");
		d1=new JTextField(15); //文本框
		d2=new JTextField(15);
		this.setTitle("查询余额"); //界面初始化
		this.setSize(450,300); //界面大小
		this.setLayout(null); //不使用默认布局
		this.setLocationRelativeTo(null); //在屏幕中间居中显示
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置仅关闭当前界面
	    this.setVisible(true); //界面可见
	    b1.setBounds(90,30,60,45); //设置标签的位置和大小
	    b2.setBounds(90,110,60,45);
		d1.setBounds(150,30,225,45); //设置文本框的位置和大小
		d2.setBounds(150,110,225,45);
		this.add(b1); //加入到界面中
		this.add(b2);
		this.add(d1);
		this.add(d2);
	    String []xinxi=new Duxie().du(ming); //读的信息传入字符串数组中
	    d1.setText(xinxi[0]); //显示
	    d2.setText(xinxi[2]);
	}

	public void actionPerformed(ActionEvent arg0){ //监听器接口里的方法
		// TODO Auto-generated method stub
	}
}

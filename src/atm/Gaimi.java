package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gaimi extends JFrame implements ActionListener{ //改密
	JButton a1; //创建按钮
	JLabel b1,b2; //创建标签
	JPasswordField e1,e2; //创建密码框
	String ming; //传入
	
	public Gaimi(String ming){
		this.ming=ming;
		a1=new JButton("确定"); //按钮
		b1=new JLabel("请输入新密码："); //标签
		b2=new JLabel("请再次输入：");
		e1=new JPasswordField(); //密码框
		e2=new JPasswordField();
		this.setTitle("改密"); //界面初始化
		this.setSize(450,300); //界面大小
		this.setLayout(null); //不使用默认布局
		this.setLocationRelativeTo(null); //在屏幕中间居中显示
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置仅关闭当前界面
	    this.setVisible(true); //界面可见
	    b1.setBounds(30,30,195,45); //设置标签的位置和大小
	    b2.setBounds(30,90,195,45);
		a1.setBounds(150,165,150,60); //设置按钮的位置和大小
		e1.setBounds(165,30,225,45); //设置密码框的位置和大小
		e2.setBounds(165,90,225,45);
		this.add(b1); //加入到界面中
		this.add(b2);
		this.add(a1);
		this.add(e1);
		this.add(e2);
		a1.addActionListener(this); //按钮监听
	}
	
	public void actionPerformed(ActionEvent e){ //重写监听器接口里的方法
		if (e.getActionCommand()=="确定")
		{
			try {
				gai();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void gai() throws IOException{ //改密验证
		String s1=String.valueOf(e1.getPassword()); //eclipse说不建议使用JPasswordField.getText()
		String s2=String.valueOf(e2.getPassword()); //就用getPassword()提取然后由char[]转换为string
		if (s1.length()<6||s2.length()<6)
		{
			JOptionPane.showMessageDialog(null,"密码长度不能小于6位！");
		}
		else if (yanzheng(s1)||yanzheng(s2))
		{
			JOptionPane.showMessageDialog(null,"不允许出现6位完全相同的情况！");
		}
		else if (s1.equals(s2)) //比较两次输入
		{
			String []xinxi=new Duxie().du(ming); //读的信息传入字符串数组中
			xinxi[1]=s1; //改密
			new Duxie().xie(xinxi); //写入文件
			JOptionPane.showMessageDialog(null,"改密成功!");
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"两次输入不一致!");
		}
	}
	
	public boolean yanzheng(String m){ //验证出现6位完全相同的情况
		for(int i=0;i<m.length();i++)
		{
			if (m.charAt(0)!=m.charAt(i))
				return false;
		}  
		return true;
	}
}

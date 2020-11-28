package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Quqian extends JFrame implements ActionListener{ //ȡǮ
	JButton a1; //������ť
	JLabel b1,b2; //������ǩ
	JTextField d1,d2,d3; //�����ı���
	String ming; //����
	
	public Quqian(String ming){
		this.ming=ming;
		a1=new JButton("ȷ��"); //��ť
		b1=new JLabel("������ȡ����(100�ı���)��"); //��ǩ
		b2=new JLabel("00  Ԫ");
		d1=new JTextField(); //�ı���
		d2=new JTextField();
		d3=new JTextField();
		this.setTitle("ȡǮ"); //�����ʼ��
		this.setSize(450,390); //�����С
		this.setLayout(null); //��ʹ��Ĭ�ϲ���
		this.setLocationRelativeTo(null); //����Ļ�м������ʾ
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //���ý��رյ�ǰ����
	    this.setVisible(true); //����ɼ�
	    b1.setBounds(60,30,195,45); //���ñ�ǩ��λ�úʹ�С
	    b2.setBounds(300,30,100,45);
		a1.setBounds(150,105,150,60); //���ð�ť��λ�úʹ�С
		d1.setBounds(260,30,30,45); //�����ı����λ�úʹ�С
		d2.setBounds(30,180,375,60);
		d3.setBounds(30,240,375,60);
		this.add(b1); //���뵽������
		this.add(b2);
		this.add(a1);
		this.add(d1);
		this.add(d2);
		this.add(d3);
		a1.addActionListener(this); //��ť����
	}
	
	public void actionPerformed(ActionEvent e){ //��д�������ӿ���ķ���
		if (e.getActionCommand()=="ȷ��")
		{
			try {
				qu();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void qu() throws IOException{ //��ʾȡ��
		if (d1.getText().isEmpty()) //ȡ����ܿ�
		{
			JOptionPane.showMessageDialog(null,"ȡ�����Ϊ�գ�");
		}
		else if(yanzheng(d1.getText()))
		{
			int a=Integer.parseInt(d1.getText())*100;
			if(a>5000)
			{
				JOptionPane.showMessageDialog(null,"ȡ����ܳ���5000��");
			}
			else
			{
				String []xinxi=new Duxie().du(ming); //������Ϣ�����ַ���������
				int c=Integer.parseInt(xinxi[2])-a; //תint
				if (c>0) //��Ϊ��
				{
					xinxi[2]=String.valueOf(c); //תstring
				    new Duxie().xie(xinxi); //д���ļ�
				    d2.setText("ȡ�����Ϊ:\n "+a); //��ʾ
				    d3.setText("�������Ϊ:\n "+xinxi[2]);
				}
			    else //����������Ϊ��
			    {
				    JOptionPane.showMessageDialog(null,"����!");
			    }
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"���������������!");
		}
		
	}
	
	public boolean yanzheng(String qian){ //��֤�������Ƿ���ȷ
		for(int i=0;i<qian.length();i++) //��λ�ж��Ƿ�Ϊ����
		{
			if (qian.charAt(i)<'0'||qian.charAt(i)>'9')
				return false;
		}  
		return true;
	}
}
package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cunqian extends JFrame implements ActionListener{ //��Ǯ
	JButton a1; //������ť
	JLabel b1; //������ǩ
	JTextField d1,d2,d3; //�����ı���
	String ming; //����
	
	public Cunqian(String ming){
		this.ming=ming;
		a1=new JButton("ȷ��"); //��ť
		b1=new JLabel("���������"); //��ǩ
		d1=new JTextField(); //�ı���
		d2=new JTextField();
		d3=new JTextField();
		this.setTitle("��Ǯ"); //�����ʼ��
		this.setSize(450,390); //�����С
		this.setLayout(null); //��ʹ��Ĭ�ϲ���
		this.setLocationRelativeTo(null); //����Ļ�м������ʾ
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //���ý��رյ�ǰ����
	    this.setVisible(true); //����ɼ�
	    b1.setBounds(30,30,195,45); //���ñ�ǩ��λ�úʹ�С
		a1.setBounds(150,105,150,60); //���ð�ť��λ�úʹ�С
		d1.setBounds(195,30,225,45); //�����ı����λ�úʹ�С
		d2.setBounds(30,180,375,60);
		d3.setBounds(30,240,375,60);
		this.add(b1); //���뵽������
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
				cun();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void cun() throws IOException{ //��ʾ����
		if (d1.getText().isEmpty()) //�����ܿ�
		{
			JOptionPane.showMessageDialog(null,"������Ϊ�գ�");
		}
		else if(yanzheng(d1.getText()))
		{
			String []xinxi=new Duxie().du(ming); //������Ϣ�����ַ���������
			int a=Integer.parseInt(xinxi[2])+Integer.parseInt(d1.getText()); //תint
			xinxi[2]=String.valueOf(a); //תstring
			new Duxie().xie(xinxi); //д���ļ�
			d2.setText("������Ϊ:\n "+d1.getText()); //��ʾ
			d3.setText("�������Ϊ:\n "+xinxi[2]);
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

package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Chaxun extends JFrame implements ActionListener{ //��ѯ
	JLabel b1,b2; //������ǩ
	JTextField d1,d2; //�����ı���
	
	public Chaxun(String ming) throws IOException{
		b1=new JLabel("�˺ţ�"); //��ǩ
		b2=new JLabel("��");
		d1=new JTextField(15); //�ı���
		d2=new JTextField(15);
		this.setTitle("��ѯ���"); //�����ʼ��
		this.setSize(450,300); //�����С
		this.setLayout(null); //��ʹ��Ĭ�ϲ���
		this.setLocationRelativeTo(null); //����Ļ�м������ʾ
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //���ý��رյ�ǰ����
	    this.setVisible(true); //����ɼ�
	    b1.setBounds(90,30,60,45); //���ñ�ǩ��λ�úʹ�С
	    b2.setBounds(90,110,60,45);
		d1.setBounds(150,30,225,45); //�����ı����λ�úʹ�С
		d2.setBounds(150,110,225,45);
		this.add(b1); //���뵽������
		this.add(b2);
		this.add(d1);
		this.add(d2);
	    String []xinxi=new Duxie().du(ming); //������Ϣ�����ַ���������
	    d1.setText(xinxi[0]); //��ʾ
	    d2.setText(xinxi[2]);
	}

	public void actionPerformed(ActionEvent arg0){ //�������ӿ���ķ���
		// TODO Auto-generated method stub
	}
}

package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Denglu extends JFrame implements ActionListener{ //��¼
	JButton a1; //������ť
	JLabel b1,b2; //������ǩ
	JTextField d1; //�����ı���
	JPasswordField e1; //���������
	String s; //����
	
	public Denglu(String s) {
		this.s=s;
		a1=new JButton("��¼"); //��ť
		b1=new JLabel("�� �ţ�"); //��ǩ
		b2=new JLabel("�� �룺");
		d1=new JTextField(15); //�ı���������
		e1=new JPasswordField(15);
		this.setTitle("��¼"); //�����ʼ��
		this.setSize(450,300); //�����С
		this.setLayout(null); //��ʹ��Ĭ�ϲ���
		this.setLocationRelativeTo(null); //����Ļ�м������ʾ
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //���ý��رյ�ǰ����
	    this.setVisible(true); //����ɼ�
	    b1.setBounds(90,30,60,45); //���ñ�ǩ��λ�úʹ�С
	    b2.setBounds(90,90,60,45);
		a1.setBounds(150,165,150,60); //���ð�ť��λ�úʹ�С
		d1.setBounds(150,30,225,45); //�����ı����������λ�úʹ�С
		e1.setBounds(150,90,225,45);
		this.add(b1); //���뵽������
		this.add(b2);
		this.add(a1);
		this.add(d1);
		this.add(e1);
		a1.addActionListener(this); //�����¼�����
	}

	public void actionPerformed(ActionEvent e){ //��д�������ӿ���ķ���
		if(e.getActionCommand()=="��¼")
		{
			try {
				tiaozhuan();
			} catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}

	public void tiaozhuan() throws IOException{ //��¼�ɹ�����ת
		String s1=String.valueOf(e1.getPassword());
		if(yanzheng(d1.getText(),s1))
		{
			JOptionPane.showMessageDialog(null,"��¼�ɹ���"); //��������
			if(s.equals("��ѯ���"))
			{
				new Chaxun(d1.getText()); //��ת����ѯ����
			}
			if(s.equals("���"))
			{
				new Cunqian(d1.getText()); //��ת��������
			}
			if(s.equals("ȡ��"))
			{
				new Quqian(d1.getText()); //��ת��ȡ�����
			}
			if(s.equals("�޸�����"))
			{
				new Gaimi(d1.getText()); //��ת�����ܽ���
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"�˺Ż�����������������룡");
		}
	}
	
    public boolean yanzheng(String ming,String mima) throws IOException{ //��֤�˺������Ƿ���ȷ
    	String []xinxi=new Duxie().du(ming); //������Ϣ�����ַ���������
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


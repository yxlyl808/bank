package atm;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gaimi extends JFrame implements ActionListener{ //����
	JButton a1; //������ť
	JLabel b1,b2; //������ǩ
	JPasswordField e1,e2; //���������
	String ming; //����
	
	public Gaimi(String ming){
		this.ming=ming;
		a1=new JButton("ȷ��"); //��ť
		b1=new JLabel("�����������룺"); //��ǩ
		b2=new JLabel("���ٴ����룺");
		e1=new JPasswordField(); //�����
		e2=new JPasswordField();
		this.setTitle("����"); //�����ʼ��
		this.setSize(450,300); //�����С
		this.setLayout(null); //��ʹ��Ĭ�ϲ���
		this.setLocationRelativeTo(null); //����Ļ�м������ʾ
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //���ý��رյ�ǰ����
	    this.setVisible(true); //����ɼ�
	    b1.setBounds(30,30,195,45); //���ñ�ǩ��λ�úʹ�С
	    b2.setBounds(30,90,195,45);
		a1.setBounds(150,165,150,60); //���ð�ť��λ�úʹ�С
		e1.setBounds(165,30,225,45); //����������λ�úʹ�С
		e2.setBounds(165,90,225,45);
		this.add(b1); //���뵽������
		this.add(b2);
		this.add(a1);
		this.add(e1);
		this.add(e2);
		a1.addActionListener(this); //��ť����
	}
	
	public void actionPerformed(ActionEvent e){ //��д�������ӿ���ķ���
		if (e.getActionCommand()=="ȷ��")
		{
			try {
				gai();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void gai() throws IOException{ //������֤
		String s1=String.valueOf(e1.getPassword()); //eclipse˵������ʹ��JPasswordField.getText()
		String s2=String.valueOf(e2.getPassword()); //����getPassword()��ȡȻ����char[]ת��Ϊstring
		if (s1.length()<6||s2.length()<6)
		{
			JOptionPane.showMessageDialog(null,"���볤�Ȳ���С��6λ��");
		}
		else if (yanzheng(s1)||yanzheng(s2))
		{
			JOptionPane.showMessageDialog(null,"���������6λ��ȫ��ͬ�������");
		}
		else if (s1.equals(s2)) //�Ƚ���������
		{
			String []xinxi=new Duxie().du(ming); //������Ϣ�����ַ���������
			xinxi[1]=s1; //����
			new Duxie().xie(xinxi); //д���ļ�
			JOptionPane.showMessageDialog(null,"���ܳɹ�!");
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"�������벻һ��!");
		}
	}
	
	public boolean yanzheng(String m){ //��֤����6λ��ȫ��ͬ�����
		for(int i=0;i<m.length();i++)
		{
			if (m.charAt(0)!=m.charAt(i))
				return false;
		}  
		return true;
	}
}

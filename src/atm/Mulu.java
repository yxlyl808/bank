package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Mulu extends JFrame implements ActionListener{ //ActionListener�ӿ��Ƕ����¼�������
	JButton a1,a2,a3,a4,a5; //������ť
	JLabel b1,b2; //������ǩ
	
	public Mulu() 
	{
		b1=new JLabel("��ӭʹ���人�Ṥ����"); //��ǩ��ʼ��
		b1.setFont(new java.awt.Font("΢���ź�",1,37)); //���ñ�ǩ���������ͣ��Ӵ֣��ֺŴ�С
		b2=new JLabel("ATM��");
		b2.setFont(new java.awt.Font("΢���ź�",1,37));
		a1=new JButton("��ѯ���"); //��ť��ʼ��
		a2=new JButton("���");
		a3=new JButton("ȡ��");
		a4=new JButton("�޸�����");
		a5=new JButton("�˳�");
		this.setTitle("ATM��Ա��ϵͳ"); //�����ʼ��
		this.setSize(600,825); //�����С
		this.setLayout(null); //��ʹ��Ĭ�ϲ���
		this.setLocationRelativeTo(null);//����Ļ�м������ʾ
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //�رս�������ֹͣ����
	    this.setVisible(true); //����ɼ�
	    b1.setBounds(120,15,450,75); //���ñ�ǩ��λ�úʹ�С
	    b2.setBounds(230,80,250,75);
		a1.setBounds(180,200,225,75); //���ð�ť��λ�úʹ�С
		a2.setBounds(180,305,225,75);
		a3.setBounds(180,410,225,75);
		a4.setBounds(180,515,225,75);
		a5.setBounds(180,620,225,75);
		this.add(b1); //���뵽������
		this.add(b2);
		this.add(a1);
		this.add(a2);
		this.add(a3);
		this.add(a4);
		this.add(a5);
		a1.addActionListener(this); //�����¼�����
		a2.addActionListener(this);
		a3.addActionListener(this);
		a4.addActionListener(this);
		a5.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){ //��д�������ӿ���ķ���
		if(e.getActionCommand()=="�˳�" ) //��ť�����£������¼�
		{
			System.exit(0); //������� 
		}
		else //����������ť
		{
			new Denglu(e.getActionCommand()); //��ת����¼����
		}
	}
	
}

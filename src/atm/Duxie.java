package atm;

import java.io.*;  

public class Duxie{ //�ļ�����
	
	public void xie(String[] xinxi)throws IOException{ //д����Ϣ
		File f=new File("atm.txt");
		String s=""; //����һ���ַ�������������Ϣ
		for (int i=0;i<3;i++) //����Ϣ��ʽ���洢
			s+=xinxi[i]+","; //��Ϣ����s��
        if(!f.exists()) //����û���ļ����ʹ���һ�����ļ�
        {
            f.createNewFile();
        }
        try { //����ļ��������
			FileWriter fw =new FileWriter(f);
			fw.write("");
			fw.flush();
	        fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        FileOutputStream chu=new FileOutputStream(f,true);
        StringBuffer sc=new StringBuffer();
        sc.append(s+"\n");
        chu.write(sc.toString().getBytes("gb2312"));
        chu.close();
	}
	
	public String[] du(String ming) throws IOException{ //����Ϣ
		File f=new File("atm.txt"); //�����ļ���
        if(!f.exists()||f.isDirectory()) //�ж��ļ��Ƿ����
        {
        	f.createNewFile(); //����һ�����ļ�
        }
        BufferedReader chu=new BufferedReader(new FileReader(f)); //����������
        String t=null;
        t=chu.readLine(); //��ȡһ�У�����t��
        if(t!=null){
        	String s=t.toString(); //ת��Ϊstring��
        	int n=s.length(); //n���ַ�������
        	String []xinxi=new String[3]; //xinxi���ַ������飬����Ϊ3
        	for(int i=0;i<3;i++)
        		xinxi[i]=""; //��ʼ��Ϊ��
        	int k=0;
        	for(int i=0;i<n;i++) //�����ȡs���ַ�
        	{
        		if(s.charAt(i)==',') //��,���
        		{
        			k++;
        		}
        		else 
        		{
        			xinxi[k]+=s.charAt(i); //��s���ַ����뵽�����һ����
        		}
        	}
        	if (xinxi[0].equals(ming))  //�����ҵ��û�����Ϣ
        	{
        		chu.close(); //�ر�
        		return xinxi;
        	}
        }
        chu.close(); //�ر�
        String[] kong=new String[3];;
		for(int i=0;i<3;i++)
    		kong[i]=""; //��ʼ��Ϊ��
        return kong; //���ؿ�����
	}
}

package atm;

import java.io.*;  

public class Duxie{ //文件操作
	
	public void xie(String[] xinxi)throws IOException{ //写入信息
		File f=new File("atm.txt");
		String s=""; //创建一个字符串用来接收信息
		for (int i=0;i<3;i++) //将信息格式化存储
			s+=xinxi[i]+","; //信息存入s中
        if(!f.exists()) //假如没有文件，就创造一个新文件
        {
            f.createNewFile();
        }
        try { //清空文件里的内容
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
	
	public String[] du(String ming) throws IOException{ //读信息
		File f=new File("atm.txt"); //创建文件类
        if(!f.exists()||f.isDirectory()) //判断文件是否存在
        {
        	f.createNewFile(); //创建一个新文件
        }
        BufferedReader chu=new BufferedReader(new FileReader(f)); //创建输入流
        String t=null;
        t=chu.readLine(); //读取一行，传入t中
        if(t!=null){
        	String s=t.toString(); //转化为string型
        	int n=s.length(); //n是字符串长度
        	String []xinxi=new String[3]; //xinxi是字符串数组，长度为3
        	for(int i=0;i<3;i++)
        		xinxi[i]=""; //初始化为空
        	int k=0;
        	for(int i=0;i<n;i++) //逐个读取s中字符
        	{
        		if(s.charAt(i)==',') //按,拆分
        		{
        			k++;
        		}
        		else 
        		{
        			xinxi[k]+=s.charAt(i); //将s中字符存入到数组的一项中
        		}
        	}
        	if (xinxi[0].equals(ming))  //返回找到用户的信息
        	{
        		chu.close(); //关闭
        		return xinxi;
        	}
        }
        chu.close(); //关闭
        String[] kong=new String[3];;
		for(int i=0;i<3;i++)
    		kong[i]=""; //初始化为空
        return kong; //返回空数组
	}
}

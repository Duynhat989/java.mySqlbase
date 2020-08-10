import java.sql.SQLException;

public class Main {
	public static void main (String [] arg)throws SQLException
	{
		String connect ="//shoponline.ckculqcubfxc.ap-southeast-1.rds.amazonaws.com";
		String namedatabase="shop";
		String user="admin";
		String pass="12345678";
		mySql kh=new mySql(connect,namedatabase,user,pass);
		for(int i=0;i<5;i++)
		{
			kh.insertMySql(i, "Blo"+i, 13+i);
		}
		kh.showMySql();
		kh.updateMySql(2, "Khanh", 11);
		kh.showMySql();
		kh.deleteMySql(1);
		kh.showMySql();
		kh.deleteMySql();
		kh.showMySql();
	}	
}
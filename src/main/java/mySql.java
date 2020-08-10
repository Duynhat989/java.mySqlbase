import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mySql {
	private String txtConnect;
	private String nameDatabase;
	private String userName;
	private String passWord;
	private Connection con;
	private PreparedStatement ps;

	mySql(String connect,String Namedata,String user,String pass)throws SQLException{
		txtConnect=connect;nameDatabase=Namedata;userName=user;passWord=pass;
		con=DriverManager.getConnection("jdbc:mysql:"+txtConnect+"/"+nameDatabase,userName,passWord);	
		System.out.println("Connect !");
	}
	public void insertMySql(int id,String name,int old) throws SQLException{
		ps=con.prepareStatement("INSERT INTO student (ID,Name,Age)\r\n" + 
				"VALUES ("+id+", '"+name+"', "+old+");");
		ps.execute();
		System.out.println("Insert success !");
	}
	public void updateMySql(int id,String name,int old) throws SQLException{
		ps=con.prepareStatement("UPDATE student "+ " SET ID = "+id+", Name = '"+name+"', Age = "+old + " WHERE ID="+id+";");
		ps.execute();
		System.out.println("Update success !");
	}
	public void deleteMySql(int id) throws SQLException{
		ps=con.prepareStatement("DELETE FROM student WHERE ID="+id+";");
		ps.execute();
		System.out.println("Delete with success !");
	}
	public void deleteMySql() throws SQLException{
		ps=con.prepareStatement("DELETE FROM student");
		ps.execute();
		System.out.println("Delete all success !");
	}
	public void showMySql() throws SQLException{
		ps=con.prepareStatement("select * from student");
		ps.execute();
		ResultSet rs = ps.getResultSet();
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name =rs.getString(2);
			int age=rs.getInt(3);
			System.out.println("ID : "+id+", Name : "+name +", Age : "+age);
		}
	}
	
}

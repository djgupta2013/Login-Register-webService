package studentInterfaceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Otp;
import bean.User;
import connection.ConnectionProvider;
import studentInterfaceDao.StudentInterface;

public class StudentImpl implements StudentInterface{
	Connection connection=null;
	PreparedStatement preparedStatement=null;

	@Override
	public String login(User user) {
			connection=ConnectionProvider.getConn();
		
		try {
			preparedStatement=connection.prepareStatement("select * from login where email=? and password=?");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				return "success";
			}
			else{
				return "Incorrect password and email";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Please register first";
	}

	@Override
	public String register(User user) {
			connection=ConnectionProvider.getConn();
		try {
			
			preparedStatement=connection.prepareStatement("select * from login where email=?");
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet=preparedStatement.executeQuery();
					if(resultSet.next()){
						return "User already exist...";
					}
					else
					{
						PreparedStatement preparedStatement2=connection.prepareStatement("insert into login values(?,?,?)");
						preparedStatement2.setString(1, user.getName());
						preparedStatement2.setString(2, user.getPassword());
						preparedStatement2.setString(3, user.getEmail());
						preparedStatement2.executeUpdate();
					}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	
	}

	@Override
	public String delete(User user) {
		
		connection=ConnectionProvider.getConn();
		try {
			
			preparedStatement=connection.prepareStatement("delete from login where email=?");
			preparedStatement.setString(1, user.getEmail());
			int flag = preparedStatement.executeUpdate();
					if(flag == 1){
						return "succeccfully delete";
					}
					else{
						return "wrong email id";
					}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "wrong email id";
		
		
	}

	@Override
	public String findId(User user) {
		connection=ConnectionProvider.getConn();
		try {
			
			preparedStatement=connection.prepareStatement("select * from login where email=?");
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet= preparedStatement.executeQuery();
			boolean flag=false;
			while(resultSet.next()) {
				
				String name=resultSet.getString("name");
				String password=resultSet.getString("password");
				String email=resultSet.getString("email");
				flag=true;
				System.out.println("Name : " +name+"\nPasswor : "+password+"\nEmail : "+email);
			}
			
					if(flag){
						return "succeccfully find";
					}
					else{
						return "email id not exist";
					}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "wrong email id";
	}

	@Override
	public String findAllId(User user) {
		
		connection=ConnectionProvider.getConn();
		try {
			
			preparedStatement=connection.prepareStatement("select * from login ");
			//preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet= preparedStatement.executeQuery();
			boolean flag=false;
			while(resultSet.next()) {
				
				String name=resultSet.getString("name");
				String password=resultSet.getString("password");
				String email=resultSet.getString("email");
				flag=true;
				System.out.println("Name : " +name+"\nPasswor : "+password+"\nEmail : "+email);
			}
			
					if(flag){
						return "succeccfully find";
					}
					else{
						return "table empty";
					}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "wrong email id";
		
	}

	@Override
	public String update(User user) {
		connection=ConnectionProvider.getConn();
		try {
			int flag = 0;
			//update name
			if((user.getName()!=null)&&(user.getEmail()!=null)&&(user.getPassword()==null)){
				preparedStatement=connection.prepareStatement("update login set name=?  where email=? ");
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getEmail());
				//flag= preparedStatement.executeUpdate();
			}
			//update password
			else if(user.getPassword()!=null&&(user.getEmail()!=null)&&(user.getName()==null)){
				preparedStatement=connection.prepareStatement("update login set password=?  where email=? ");
				preparedStatement.setString(1, user.getPassword());
				preparedStatement.setString(2, user.getEmail());
				//flag= preparedStatement.executeUpdate();
			}
			//update email
			else if(user.getNewEmail()!=null&&(user.getEmail()!=null)){
				preparedStatement=connection.prepareStatement("update login set email=?  where email=? ");
				preparedStatement.setString(1, user.getNewEmail());
				preparedStatement.setString(2, user.getEmail());
			}
			//update name and email both
			else if((user.getName()!=null)&&(user.getPassword()!=null)&&(user.getEmail()!=null)){
				preparedStatement=connection.prepareStatement("update login set name=?, password=?  where email=? ");
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getEmail());	
			}
			 flag= preparedStatement.executeUpdate();
			if(flag==1){
				return "succeccfully update";
			}
			else{
				return "{'msg' : 'enter wrong email'}";
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "wrong email id";
		
		
	}

	@Override
	public String verifyOtp(Otp otp) {
		
		return null;
	}

	
	

}

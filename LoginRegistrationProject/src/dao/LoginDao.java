package dao;


public class LoginDao {
	
	/*public String login(User user)
	{
		Connection connection=ConnectionProvider.getConn();
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from login where email=? and password=?");
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
			
		}
		return "Please register first";
		
	}
*/
}

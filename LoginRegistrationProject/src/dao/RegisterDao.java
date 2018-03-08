package dao;



public class RegisterDao {

	/*public String register(User user)
	{
		Connection connection=ConnectionProvider.getConn();
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from login where email=?");
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
			// TODO: handle exception
		}
		return "fail";
		
	}*/
}

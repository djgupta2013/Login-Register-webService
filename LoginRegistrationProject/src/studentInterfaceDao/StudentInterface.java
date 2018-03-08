package studentInterfaceDao;

import bean.Otp;
import bean.User;

public interface StudentInterface {
	
	String login(User user);
	String register(User user);
	String delete(User user);
	String findId(User user);
	String findAllId(User user);
	String update(User user);
	String verifyOtp(Otp otp);

}

package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DataDrivenTests
{
	@Test(priority = 1,dataProvider = "Object",dataProviderClass =Dataproviders.class)//Here Dataproviders.class
	public void testPostUser(String userID, String fname, String UserName, String lName, String useremail, String pwd, String ph)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(UserName);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "UserName", dataProviderClass =Dataproviders.class )//Here Dataproviders.class
	public void testDeleteUserByName(String userName)
	{
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}

package api.endpoints;

//Here all the URL's are maintained.
/*
   Swagger URL ="https://petstore.swagger.io/"
   Create User(Post)= https://petstore.swagger.io/v2/user
   Get USer(Get) = https://petstore.swagger.io/v2/user/{username}
   Update User(Put)=https://petstore.swagger.io/v2/user/{username}
   Delete User(Delete)=https://petstore.swagger.io/v2/user/{username}
 */

public class Routes 
{
	public static String base_url ="https://petstore.swagger.io/v2";
	
	//user module in petstore swagger
	
	public static String post_url= base_url+"/user";
	public static String get_url= base_url+"/user/{username}";
	public static String update_url= base_url+"/user/{username}";
	public static String delete_url= base_url+"/user/{username}";
	
	//store module
	
	   //Here you wil create Store module URL's
	
	//pet module
	    
	    //Here you will create Pet module URL's
	
}

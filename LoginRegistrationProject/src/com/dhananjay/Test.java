package com.dhananjay;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import bean.User;
import studentInterfaceImpl.StudentImpl;

@Path("hello")
public class Test {
	User user=null;
	StudentImpl studentImpl=null;
	
	//using post
	/*@Path("register")
	@POST 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getRegister(String json){
		 studentImpl=new StudentImpl();
	
		JsonParser jsonParser=new JsonParser();
		JsonElement jsonElement=jsonParser.parse(json);
		if(jsonElement.isJsonObject()){
			
			JsonObject jsonObject=jsonElement.getAsJsonObject();
			
		
			user=new User(jsonObject.get("name").getAsString(),jsonObject.get("password").getAsString(),jsonObject.get("email").getAsString());
		}
		
		
		String msg=studentImpl.register(user);
		if(msg.equals("success")) {
			
			return "{'msg' : 'fail'}";
		}
		else if(msg.equals("fail")) {
			
			return "{'msg' : 'success'}";
		}
		else{
			return "User already exist";
		}	
	}*/
	//using get
	@Path("register/{name}/{password}/{email}")
	@GET
	public String getRegister(@PathParam("name")String name,@PathParam("password")String password,@PathParam("email")String email ){
		 studentImpl=new StudentImpl();
		 if(name!=null&&password!=null&&email!=null){
			user=new User(name,password,email); 
			 
		 }
		String msg=studentImpl.register(user);
		if(msg.equals("success")) {
			
			return "{'msg' : 'fail'}";
		}
		else if(msg.equals("fail")) {
			
			return "{'msg' : 'success'}";
		}
		else{
			return "User already exist";
		}	
	}
	//using get..
	@Path("login/{email}/{password}")
	@GET
	public String getlogin(@PathParam("email")String email,@PathParam("password")String password) {
		
		if(email!=null&&password!=null){
			user=new User(email,password);
		}
		else{
			return "{'msg' : 'Incorrect password and email'}";
		}
		studentImpl=new StudentImpl();
		String msg=studentImpl.login(user);
		if(msg.equals("success")){
			return "{'msg' : 'success'}";
		}
		else if(msg.equals("Incorrect password and email")){
			return "{'msg' : 'Incorrect password and email'}";
		}
		else{
			return "{'msg' : 'Please register first'}";
		}
	}
	
	//using post
	/*@Path("login")
	@POST 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getlogin(String json) {
		
		
		JsonParser jsonParser=new JsonParser();
		JsonElement jsonElement=jsonParser.parse(json);
		if(jsonElement.isJsonObject()) {
			
			JsonObject jsonObject=jsonElement.getAsJsonObject();
			user=new User(jsonObject.get("email").getAsString(), jsonObject.get("password").getAsString());
		}
		studentImpl=new StudentImpl();
		String msg=studentImpl.login(user);
		if(msg.equals("success")){
			return "{'msg' : 'success'}";
		}
		else if(msg.equals("Incorrect password and email")){
			return "{'msg' : 'Incorrect password and email'}";
		}
		else{
			return "{'msg' : 'Please register first'}";
		}
	}*/
	
	//using post
/*	@Path("delete")
	@POST 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getDelete(String json){
		
		JsonParser jsonParser=new JsonParser();
		JsonElement jsonElement=jsonParser.parse(json);
		if(jsonElement.isJsonObject()) {
			
			JsonObject jsonObject=jsonElement.getAsJsonObject();
			user=new User(jsonObject.get("email").getAsString());
		}
		studentImpl=new StudentImpl();
		String msg=studentImpl.delete(user);
		if(msg.equals("succeccfully delete")){
			return "{'msg' : 'succeccfully delete'}";
		}
		else{
			return "{'msg' : 'wrong email id'}";
		}	
	}*/
	
	//using get
	@Path("delete/{id}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public String getDelete(@PathParam("id") String emailId){
		
		if(!emailId.isEmpty() && emailId != null){
			user=new User(emailId);
		}
		else{
			return "{'msg' : 'wrong email id'}";
		}
		studentImpl=new StudentImpl();
		String msg=studentImpl.delete(user);
		if(msg.equals("succeccfully delete")){
			return "{'msg' : 'succeccfully delete'}";
		}
		else{
			return "{'msg' : 'wrong email id'}";
		}
	}
	
	
	
	//using get
	@Path("findId/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String findId(@PathParam("id") String emailId){
		
		if(!emailId.isEmpty() && emailId != null) {
			user=new User(emailId);
		} else {
			return "{'msg' : 'email id not exist'}";
		}
		studentImpl=new StudentImpl();
		String msg=studentImpl.findId(user);
		if(msg.equals("succeccfully find")){
			return "{'msg' : 'succeccfully find'}";
		}
		else{
			return "{'msg' : 'email id not exist'}";
		}	
	}

	//using post..
	
	/*@Path("findId")
	@POST 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String findId(String json){
		
		JsonParser jsonParser=new JsonParser();
		JsonElement jsonElement=jsonParser.parse(json);
		if(jsonElement.isJsonObject()) {
			
			JsonObject jsonObject=jsonElement.getAsJsonObject();
			user=new User(jsonObject.get("email").getAsString());
		}
		studentImpl=new StudentImpl();
		String msg=studentImpl.findId(user);
		if(msg.equals("succeccfully find")){
			return "{'msg' : 'succeccfully find'}";
		}
		else{
			return "{'msg' : 'email id not exist'}";
		}	
	}*/
	
	@Path("findAllId")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String findAllId(String json){
		/*
		JsonParser jsonParser=new JsonParser();
		JsonElement jsonElement=jsonParser.parse(json);
		if(jsonElement.isJsonObject()) {
			
			JsonObject jsonObject=jsonElement.getAsJsonObject();
			user=new User(jsonObject.get("email").getAsString());
		}*/
		studentImpl=new StudentImpl();
		String msg=studentImpl.findAllId(user);
		if(msg.equals("succeccfully find")){
			return "{'msg' : 'succeccfully find'}";
		}
		else{
			return "{'msg' : 'table empty'}";
		}
	}
	
	@Path("update")
	@POST 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String json){
		user=new User();
		JsonParser jsonParser=new JsonParser();
		JsonElement jsonElement=jsonParser.parse(json);
		if(jsonElement.isJsonObject()) {
			JsonObject jsonObject=jsonElement.getAsJsonObject();
			//name update only
			if(jsonObject.get("name")!=null &&(jsonObject.get("email")!=null)&&(jsonObject.get("password")==null)){
				user.updateName(jsonObject.get("name").getAsString(), jsonObject.get("email").getAsString());
			}
			//password update
			else if(jsonObject.get("name")==null && (jsonObject.get("password")!=null)&&(jsonObject.get("password")!=null) )
			user.updatePassword(jsonObject.get("password").getAsString(),jsonObject.get("email").getAsString());
			
			//email update 
			else if((jsonObject.get("newEmail")!=null) && (jsonObject.get("email")!=null))
				user.updateEmail(jsonObject.get("newEmail").getAsString(), jsonObject.get("email").getAsString());
			
			//update name and password both
			else if(jsonObject.get("name")!=null && (jsonObject.get("password")!=null)&&(jsonObject.get("email")!=null))
				user=new User(jsonObject.get("name").getAsString(),jsonObject.get("password").getAsString(),jsonObject.get("email").getAsString());
		}
		studentImpl=new StudentImpl();
		String msg=studentImpl.update(user);
		if(msg.equals("succeccfully update")){
			return "{'msg' : 'succeccfully update'}";
		}
		else{
			return "{'msg' : 'enter wrong email'}";
		}	
	}
	
	
}

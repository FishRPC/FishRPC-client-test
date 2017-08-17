package com.fish.rpc.test.hello;

import com.fish.rpc.core.client.FishRPCClientInit;
import com.fish.rpc.core.client.FishRPCExecutorClient;
import com.fish.rpc.test.add.IAdd;
import com.fish.rpc.test.multi.IMulti;
 
public class TestRPC {
	public static void main(String[] args)    {
		
		FishRPCClientInit.getInstance().init(null);
		
	 
			
			try{
			long start = System.currentTimeMillis();
			/*ISayHello sayHello = (ISayHello)FishRPCExecutorClient.getInstance().getBean(ISayHello.class);
		    
			
			sayHello.hello(); 
		    System.out.println("sayHello.helloInt()"+(System.currentTimeMillis() - start));
		    
		    start = System.currentTimeMillis();
		    Person p = new Person();
		    p.setAge(20);
		    p.setName("fishRPC-save");
		    System.out.println("sayHello.savePerson()"+(System.currentTimeMillis() - start));
		    
	 	    
		    start = System.currentTimeMillis();
		    sayHello.getPersion();
		    System.out.println("sayHello.getPersion()"+(System.currentTimeMillis() - start));*/
		    
		 
		    start = System.currentTimeMillis();
			IAdd add = (IAdd)FishRPCExecutorClient.getInstance().getBean(IAdd.class);
			int a = add.add(1,null, 1);
			System.out.println("IAdd.add() = "+a+",spend:"+(System.currentTimeMillis() - start));
		 
			
			IMulti m = (IMulti)FishRPCExecutorClient.getInstance().getBean(IMulti.class);
			System.out.println(m.multi(6, 5));
			/*start = System.currentTimeMillis();
			
			/*IMulti multi = (IMulti)FishRPCExecutorClient.getInstance().getBean(IMulti.class);
			
			Thread.sleep(10000);
			System.out.println("start multi...");
			System.out.println("result:"+multi.multi(1, 1));
			System.out.println("end multi...");*/
		//	System.out.println("IMulti.multi()"+(System.currentTimeMillis() - start));
			
			
			}catch(Exception e){
				e.printStackTrace();
			} 
	}
	  

}

package com.fish.rpc.test.hello;

import com.fish.rpc.core.client.FishRPCExecutorClient;
import com.fish.rpc.test.add.IAdd;
import com.fish.rpc.test.dto.Person;
import com.fish.rpc.test.multi.IMulti;
 
public class TestRPC {
	public static void main(String[] args) throws Exception {
		
		while(true){
		ISayHello sayHello = (ISayHello)FishRPCExecutorClient.getInstance().getBean(ISayHello.class);
	    
		long start = System.currentTimeMillis();
		sayHello.hello(); 
	    System.out.println("sayHello.helloInt()"+(System.currentTimeMillis() - start));
	    
	    start = System.currentTimeMillis();
	    Person p = new Person();
	    p.setAge(20);
	    p.setName("fishRPC-save");
	    System.out.println("sayHello.savePerson()"+(System.currentTimeMillis() - start));
	    
 	    
	    start = System.currentTimeMillis();
	    sayHello.getPersion();
	    System.out.println("sayHello.getPersion()"+(System.currentTimeMillis() - start));
	    
	    start = System.currentTimeMillis();
		IAdd add = (IAdd)FishRPCExecutorClient.getInstance().getBean(IAdd.class);
		add.add(1, 1);
		System.out.println("IAdd.add()"+(System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		IMulti multi = (IMulti)FishRPCExecutorClient.getInstance().getBean(IMulti.class);
		multi.multi(1, 1);
		System.out.println("IMulti.multi()"+(System.currentTimeMillis() - start));
		}
	 
	    
	}

}

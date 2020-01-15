package com.fish.rpc.test.hello;

import java.util.List;

import com.fish.rpc.core.client.FishRPCClientInit;
import com.fish.rpc.core.client.FishRPCExecutorClient;
import com.fish.rpc.test.add.IAdd;
import com.fish.rpc.test.dto.Person;
import com.fish.rpc.test.multi.IMulti;

public class TestRPC {
	public static void main(String[] args) {

		FishRPCClientInit.getInstance().init(null);

		try {
			long start = System.currentTimeMillis();
			ISayHello sayHello = (ISayHello)FishRPCExecutorClient.getInstance().getBean(ISayHello.class);
			System.out.println("--------------");
			int count = 0;
			while(true) {
				String echo = sayHello.echo("i am an client " + count++);
				System.out.println(echo);
				Thread.sleep(100l);
			}
			/*
			 * ISayHello sayHello =
			 * (ISayHello)FishRPCExecutorClient.getInstance().getBean(ISayHello.
			 * class);
			 *
			 *
			 * sayHello.hello();
			 * System.out.println("sayHello.helloInt()"+(System.
			 * currentTimeMillis() - start));
			 *
			 * start = System.currentTimeMillis(); Person p = new Person();
			 * p.setAge(20); p.setName("fishRPC-save");
			 * System.out.println("sayHello.savePerson()"+(System.
			 * currentTimeMillis() - start));
			 *
			 *
			 * start = System.currentTimeMillis(); sayHello.getPersion();
			 * System.out.println("sayHello.getPersion()"+(System.
			 * currentTimeMillis() - start));
			 */

			/*IAdd add = (IAdd) FishRPCExecutorClient.getInstance().getBean(IAdd.class);

			start = System.currentTimeMillis();
			int a = add.add(1, null, 1);
			System.out.println("IAdd.add()1 = " + a + ",spend:" + (System.currentTimeMillis() - start));
  */

			/*for(int i=0;i<50;i++){
				start = System.currentTimeMillis();
	 			a = add.add(1, null, 1);
				System.out.println("IAdd.add()2 = " + a + ",spend:" + (System.currentTimeMillis() - start));
				Thread.sleep(1000);
			}*/
			/*IMulti m = (IMulti) FishRPCExecutorClient.getInstance().getBean(IMulti.class);
			System.out.println(m.multi(6, 5));*/



			/*IBigdata IBigdata = (IBigdata) FishRPCExecutorClient.getInstance().getBean(IBigdata.class);
			List<Person> list = IBigdata.list();
			System.out.println(list);*/

			/*
			 * start = System.currentTimeMillis();
			 *
			 * /*IMulti multi =
			 * (IMulti)FishRPCExecutorClient.getInstance().getBean(IMulti.class)
			 * ;
			 *
			 * Thread.sleep(10000); System.out.println("start multi...");
			 * System.out.println("result:"+multi.multi(1, 1));
			 * System.out.println("end multi...");
			 */
			// System.out.println("IMulti.multi()"+(System.currentTimeMillis() -
			// start));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

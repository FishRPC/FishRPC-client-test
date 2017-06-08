package com.fish.rpc.test.parallel;

import com.fish.rpc.test.add.IAdd;

public class AddImpl implements IAdd{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

}

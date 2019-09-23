package com.ziyin.java8;

/**
 * @author ziyin
 * @create 2019-08-21 23:03
 * assert 是1.4加入java中
 *
 */
public class AssertTest {

	public static void main(String[] args) {
		int num = 8;
		assert num == 10 : "num内容不是10";
		System.out.println(num);
	}
}

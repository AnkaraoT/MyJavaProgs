package com.myjava.prog;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// \u000d System.out.println("comment printed :  ");

		List<Integer> integers = IntStream.range(1, 100).boxed().collect(Collectors.toCollection(ArrayList::new));

		Optional<Integer> max = integers.stream().reduce(Math::max);

		max.ifPresent(System.out::println);
	}

}

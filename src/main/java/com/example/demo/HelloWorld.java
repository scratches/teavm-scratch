package com.example.demo;

import am.ik.yavi.builder.ValidatorBuilder;

public class HelloWorld {

	private am.ik.yavi.core.Validator<Foo> bundle;

	public static void main(String[] args) {
		System.out.println("Valid: " + new HelloWorld().validate("foo"));
	}

	HelloWorld() {
		this.bundle = ValidatorBuilder.<Foo>of(Foo.class).constraint(Foo::getValue, "value", c -> c.notBlank()).build();
	}

	public boolean validate(String value) {
		return bundle.validate(new Foo(value)).isEmpty();
	}

}

class Foo {
	private String value;
	public Foo(String string) {
		value = string;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
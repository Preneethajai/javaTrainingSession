package com.te.javabasic.diffaccessmodifier;

public class AccessModifier {
	public void publicModifier() {
		System.out.println("Public method");
	}

	protected void protectedModifier() {
		System.out.println("Protected method");
	}

	void defaultModifier() {
		System.out.println("default method");
	}

	private void privateModifier() {
		System.out.println("private method");
	}

	public static void main(String[] args) {
		AccessModifier accessModifier = new AccessModifier();
		accessModifier.defaultModifier();
		accessModifier.publicModifier();
		accessModifier.protectedModifier();
		accessModifier.privateModifier();
	}

}

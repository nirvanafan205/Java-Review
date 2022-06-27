public class interfaces_defineTypes
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	//Constant interface antipattern - don't use
	public interface PhysicalConstants
	{
		//Avogadro's number 1/mol
		static final double AVOGADROS_NUMBER = 6.02214199e23;

		//Boltzman constant J/k
		static final double BOLTZMANN_CONSTANT = 1.3806503e-23;

		//Mass of electron kg
		static final double ELECTRON_MASS = 9.10938188e-31;

		//The constant interface patter is a poor use of interfaces
	}

	//use utility class
	
	//package com.effectivejava.science
	
	public class PhysicalConstants
	{
		private PhysicalConstrants() {} //prevents instantiation

		public static final double AVOGADROS_NUMBER = 6.02214199e23;

		public static final double BOLTZMANN_CONSTANT = 1.3806503e-23;

		public static final double ELECTRON_MASS = 9.10938188e-31;
	}
	// interfaces should be used only to define types
	// not to be used to export constants
}

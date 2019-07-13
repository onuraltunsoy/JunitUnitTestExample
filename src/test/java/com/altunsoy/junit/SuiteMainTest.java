package com.altunsoy.junit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AssertJunitParamsTest.class,
	AssertTest.class,
	ParameterTest.class
})
public class SuiteMainTest {
	
}
package 大脑.测试;

import java.lang.annotation.ElementType;

import java.lang.annotation.Inherited;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;

	public class MyAnnotation {

	   

	    @Inherited

	    @Target(ElementType.TYPE)

	    @Retention(RetentionPolicy.RUNTIME)

	    public @interface 实体类 {

	        public String name();

	        public String value() default "默认value";

	        public String 类名() default "";

	       

	        public enum ParameterType { STRING, SHORT, INT, BOOL, LONG, OBJECT };

	 

	        public boolean ignoreCase() default false;

	        public ParameterType type() default ParameterType.STRING;

	       

	    }

	 

	}

	 

	 

	 

	

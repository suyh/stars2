package 大脑.测试;

import 大脑.测试.MyAnnotation.实体类;

@实体类(name = "java class")

public class AnnotationTest {

 

    public static void main(String[] args) {

        实体类 注解1 = AnnotationTest.class.getAnnotation(实体类.class);

        实体类 注解2 = (实体类) AnnotationTest.class.getAnnotations()[0];

       

        System.out.println(注解1.value());

        System.out.println(注解1.类名());

        System.out.println(注解1.name());

    }

 

}

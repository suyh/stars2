package 大脑.测试;

import 大脑.测试.MyAnnotation.实体类;

public class dealAnnotation {

	 

    public static void main(String[] args) {

        boolean isEntity = AnnotationTest.class.isAnnotationPresent(实体类.class);

        System.out.println(isEntity);

        if(isEntity){

            //操作json to mongodb

        }

       

        实体类 注解1 = AnnotationTest.class.getAnnotation(实体类.class);

//      实体类 注解2 = (实体类) AnnotationTest.class.getAnnotations()[0];

        if(注解1.value().equals("somevalue")){

            //操作json to mongodb

        }

    }

 

}
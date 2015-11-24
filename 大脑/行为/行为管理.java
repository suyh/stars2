package 大脑.行为;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import 大脑.会话.会话场景;
import 大脑.自我.世界;

//该类是类集中所有类的方法的具体实现,所有方法都会调用该类中的"行为"方法
public class 行为管理 {
	
	public void 行为 (Object 谁,Object 谁的, Object 附属, String 值,String 行为名称) throws Exception{

	       

        if(谁的 != null && 附属 != null && 值 != null){

           //他把我的眼睛打瞎了

            Class 谁的_类 = 谁的.getClass();

            Field 域 = 谁的_类.getDeclaredField(附属.getClass().getName());

            域.set(谁的, 值);

        }else if(谁的 == null && 附属 != null && 值 != null){

           //他把眼睛打瞎了

            Class 谁的_类 = 谁.getClass();

            Field 域 = 谁的_类.getDeclaredField(附属.getClass().getName());

           

            if(域 == null){//or use try-catch block to determine 附属 the field is belong to.

                域 = 世界.class.getDeclaredField(附属.getClass().getName());

                域.set(世界.class.newInstance(), 值);

            }else{

                域.set(谁, 值);
            }  

        }else if(谁的 == null && 附属 == null && 值 != null){

           //他吃饱了
        	
            Field[] 属性集 = 谁.getClass().getDeclaredFields();

            for(Field field:属性集){

                if(field.getName().equals(值)){

                    field.set(谁, 值);

                    return;
                }
            }
           
            List<Field> 属性列表 = new ArrayList<Field>();

            for(Field 属性:属性集){

                Field[] 属性集2 = Class.forName(属性.getName()).getDeclaredFields();

                for(Field 属性2:属性集2){

                    if(属性2.getName().equals(值)){

                        属性列表.add(属性2);
                    }
                }
            }

            if(属性列表.isEmpty()){

                System.out.println("What field is "+值+"?");

            }else if(属性列表.size()>1){

                System.out.println("which field?");

                for(Field field:属性列表){
                	
                    System.out.print(field.getName()+" or ");
                }
                
            }else{
            	
                属性列表.get(0).set(谁, 值);
                
            }

        }else if(谁的 != null && 附属 == null && 值 != null){

            // 他把我打瞎了

            Field[] 属性集 = 谁的.getClass().getDeclaredFields();

            List<Field> 属性列表 = new ArrayList<Field>();

            for(Field 属性:属性集){

                Field[] 属性集2 = Class.forName(属性.getName()).getDeclaredFields();

                for(Field 属性2:属性集2){

                    if(属性2.getName().equals(值)){

                        属性列表.add(属性2);
                    }
                }
            }

            if(属性列表.isEmpty()){

                System.out.println("What field is "+值+"?");

            }else if(属性列表.size()>1){

                System.out.println("which field?");

                for(Field field:属性列表){

                    System.out.print(field.getName()+" or ");
                }

            }else{

                属性列表.get(0).set(谁的, 值);
            }

        }else if(谁的 != null && 附属 != null && 值 == null){
            //他打了我的头
            //不会改变任何属性值,但是这次调用会被记录
        }else if(谁的 != null && 附属 == null && 值 == null){
            // 你打了我;
        	//不会改变任何属性值,但是这次调用会被记录
        }

    }

    public void session(){

        会话场景 scene = new 会话场景();

        scene.add("(he)->Certain person", "david");

        scene.add("kicked", "david");

        scene.add("(my)->David", "david");

        scene.add("eyes", "david");

    }
}

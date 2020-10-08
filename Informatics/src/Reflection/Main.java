package Reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
//Получать информацию о классе по его имени
//Получать информацию обо всех полях класса


public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Human human = new Human();
        human.age = 19;
        human.height = 1.45;
        human.grow();
        human.grow();
        System.out.println(human.height);
        human.printAge();*/

        Class<?> aClass = Class.forName("Reflection.Human");//загружает класс в виртуальную машину,
        // я еще и получила описание этого класса -> Сlass

        System.out.println(aClass.getName());
        Field[] fields = aClass.getDeclaredFields();//возвращает массив полей класса


        for (Field field: fields){
            System.out.print(field.getName()+ " ");
            System.out.println(field.getType());

        }
        //Human human1 = (Human) aClass.newInstance();
        //Human human1 = new Human();
        Constructor constructor =aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Human human1 = (Human) constructor.newInstance();


        human1.height = 1.40;

        Field field = aClass.getDeclaredField("age");
        field.setAccessible(true);
        field.set(human1, 12);
        human1.printAge();

       Method methods[] =aClass.getDeclaredMethods();

       for (Method method: methods){
           System.out.print(method.getName()+" ");
           System.out.print(method.getReturnType()+" ");
           System.out.println(method.getParameterCount()+" ");

       }

 //      Method method = aClass.getDeclaredMethod("grow");
       Method method =aClass.getMethod("grow",Double.TYPE);
       method.invoke(human1,0.01);
        System.out.println(human1.height);

        Method methodWithReturn = aClass.getMethod("getHeight");
        Object result = methodWithReturn.invoke(human1);
        System.out.println(result);
    }
}

package com.fslqup.day05.TryCatch;

import java.util.List;

/*try catch：一次捕获，多次处理
* finally中不能有return
*
* */
public class DemoCatch {
    public static void main(String[] args) {
        try{
            List<Integer> list=List.of (1,2,3);

            list.get (3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println (e);
        }catch (IndexOutOfBoundsException e){
            System.out.println (e);
        }
        System.out.println ("后续代码！");
    }
}

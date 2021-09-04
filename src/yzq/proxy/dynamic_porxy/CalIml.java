package yzq.proxy.dynamic_porxy;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 实现类（委托类）
 * @date : 2021/9/4
 * @time : 15:41
 */
public class CalIml implements Calculate {


    @Override
    public int add(Integer num1, Integer num2) {

        return num1 + num2;

    }

    @Override
    public int sub(Integer num1, Integer num2) {
        return num1 - num2;
    }

    @Override
    public int mul(Integer num1, Integer num2) {
        return num1 * num2;
    }

    @Override
    public int div(Integer num1, Integer num2) {
        return num1 / num2;
    }


}

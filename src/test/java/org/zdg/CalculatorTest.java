package org.zdg;

import org.zdg.calculator.Calculator;
import org.zdg.calculator.Operator;
import org.zdg.calculator.impl.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangdage
 * @create 2023/7/4 18:46
 */
public class CalculatorTest {

    public static void main(String[] args) {

        Calculator calculator = new BaseCalculator(BigDecimal.valueOf(0));

        Operator add = new AddOperator(null, null);
        Operator subtract = new SubtractOperator(null, null);
        Operator multiply = new MultiplyOperator(null, null);
        Operator divide = new DivideOperator(3, RoundingMode.HALF_DOWN);

        //测试相加
        calculator.execute(add,BigDecimal.valueOf(2));
        System.out.println("+2="+calculator.getResult());
        assert BigDecimal.valueOf(2).equals(calculator.getResult()):"相加计算异常";

        //测试相减
        calculator.execute(subtract,BigDecimal.valueOf(1));
        System.out.println("-1="+calculator.getResult());
        assert BigDecimal.valueOf(1).equals(calculator.getResult()):"相减计算异常";

        //测试相乘
        calculator.execute(multiply,BigDecimal.valueOf(4));
        System.out.println("*4="+calculator.getResult());
        assert BigDecimal.valueOf(4).equals(calculator.getResult()):"相乘计算异常";

        //测试相除
        calculator.execute(divide,BigDecimal.valueOf(2));
        System.out.println("/2="+calculator.getResult());
        assert BigDecimal.valueOf(2).setScale(3, RoundingMode.HALF_DOWN).equals(calculator.getResult()):"相除计算异常";


        //测试undo
        calculator.undo();
        System.out.println("undo="+calculator.getResult());
        assert BigDecimal.valueOf(4).equals(calculator.getResult()):"undo异常";

        //测试redo
        calculator.redo();
        System.out.println("redo="+calculator.getResult());
        assert BigDecimal.valueOf(2).setScale(3, RoundingMode.HALF_DOWN).equals(calculator.getResult()):"redo异常";

    }
}

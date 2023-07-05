package org.zdg.calculator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangdage
 * @create 2023/7/4 18:02
 */
public class MultiplyOperator extends AbstractOperator{

    public MultiplyOperator(Integer scale, RoundingMode roundingMode){
        super.setScale(scale);
        super.setRoundingMode(roundingMode);
    }

    @Override
    public BigDecimal operate(BigDecimal first, BigDecimal second) {

        BigDecimal multiply = first.multiply(second);
        if(super.getScale() != null && super.getRoundingMode() != null){
            multiply = multiply.setScale(super.getScale(),super.getRoundingMode());
        }else if(super.getScale() != null){
            multiply = multiply.setScale(super.getScale());
        }
        return multiply;
    }
}

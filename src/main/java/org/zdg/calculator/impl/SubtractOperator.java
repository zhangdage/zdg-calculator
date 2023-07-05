package org.zdg.calculator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangdage
 * @create 2023/7/4 18:01
 */
public class SubtractOperator extends AbstractOperator{

    public SubtractOperator(Integer scale, RoundingMode roundingMode){
        super.setScale(scale);
        super.setRoundingMode(roundingMode);
    }

    @Override
    public BigDecimal operate(BigDecimal first, BigDecimal second) {

        BigDecimal subtract = first.subtract(second);
        if(super.getScale() != null && super.getRoundingMode() != null){
            subtract = subtract.setScale(super.getScale(),super.getRoundingMode());
        }else if(super.getScale() != null){
            subtract = subtract.setScale(super.getScale());
        }
        return subtract;
    }
}

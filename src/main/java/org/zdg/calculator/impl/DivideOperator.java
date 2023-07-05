package org.zdg.calculator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangdage
 * @create 2023/7/4 18:03
 */
public class DivideOperator extends AbstractOperator{

    public DivideOperator(Integer scale, RoundingMode roundingMode){
        super.setScale(scale);
        super.setRoundingMode(roundingMode);
    }

    @Override
    public BigDecimal operate(BigDecimal first, BigDecimal second) {

        if(super.getScale() != null && super.getRoundingMode() != null){
            return first.divide(second,super.getScale(),super.getRoundingMode());
        }else if(super.getRoundingMode() != null){
            return first.divide(second,super.getRoundingMode());
        }
        return first.divide(second);
    }
}

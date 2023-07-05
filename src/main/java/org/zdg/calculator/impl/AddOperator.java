package org.zdg.calculator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangdage
 * @create 2023/7/4 18:00
 */
public class AddOperator extends AbstractOperator{

    public AddOperator(Integer scale, RoundingMode roundingMode){
        super.setScale(scale);
        super.setRoundingMode(roundingMode);
    }

    @Override
    public BigDecimal operate(BigDecimal first, BigDecimal second) {

        BigDecimal add = first.add(second);
        if(super.getScale() != null && super.getRoundingMode() != null){
            add = add.setScale(super.getScale(),super.getRoundingMode());
        }else if(super.getScale() != null){
            add = add.setScale(super.getScale());
        }
        return add;
    }
}

package org.zdg.calculator.impl;

import org.zdg.calculator.Operator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangdage
 * @create 2023/7/4 18:24
 */
public abstract class AbstractOperator implements Operator {

    private Integer scale;
    private RoundingMode roundingMode;

    public abstract BigDecimal operate(BigDecimal first, BigDecimal second);

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }
}

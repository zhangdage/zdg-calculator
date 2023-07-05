package org.zdg.calculator;

import java.math.BigDecimal;

/**
 * @author zhangdage
 * @create 2023/7/4 16:50
 */
public interface Operator {

    BigDecimal operate(BigDecimal first, BigDecimal second);
}

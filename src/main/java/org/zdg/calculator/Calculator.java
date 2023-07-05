package org.zdg.calculator;

import java.math.BigDecimal;

public interface Calculator {

    Calculator execute(Operator operator,BigDecimal value);

    Calculator undo();

    Calculator redo();

    BigDecimal getResult();
}

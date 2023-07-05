package org.zdg.calculator.impl;

import org.zdg.calculator.Calculator;
import org.zdg.calculator.Operator;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author zhangdage
 * @create 2023/7/4 18:23
 */
public class BaseCalculator implements Calculator {

    //撤回栈，记录每一步操作结果
    private Stack<BigDecimal> undoStack = new Stack<>();

    //重做栈，记录撤回的操作结果
    private Stack<BigDecimal> redoStack = new Stack<>();

    public BaseCalculator(BigDecimal firstValue){
        if(firstValue == null){
            this.undoStack.push(BigDecimal.valueOf(0));
        }
        this.undoStack.push(firstValue);
    }

    /**
     * 运算操作
     * @param operator
     * @param value
     * @return
     */
    @Override
    public Calculator execute(Operator operator, BigDecimal value) {
        this.undoStack.push(operator.operate(this.undoStack.peek(),value));
        return this;
    }

    /**
     * 撤销操作
     * @return
     */
    @Override
    public Calculator undo() {
        if(this.undoStack.size() == 1){
            this.undoStack.peek();
        }else{
            this.redoStack.push(this.undoStack.pop());
        }

        return this;
    }

    /**
     * 重做操作
     * @return
     */
    @Override
    public Calculator redo() {
        if(this.redoStack.size() != 0){
            this.undoStack.push(this.redoStack.pop());
        }
        return this;
    }

    /**
     * 获取计算结果
     * @return
     */
    @Override
    public BigDecimal getResult() {
        return this.undoStack.peek();
    }
}

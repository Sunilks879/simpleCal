package com.cts;

import com.cts.commands.*;
import com.cts.exception.DivisionByZeroException;
import com.cts.exception.NegativePowerException;
import org.springframework.stereotype.Service;

import java.util.stream.LongStream;

@Service
public class MathOperator implements Adder, Subtractor, Multiplier, Divider, Power {

    @Override
    public long add(long... operands) {
        return LongStream.of(operands).reduce((l, r) -> l + r).getAsLong();
    }

    @Override
    public long subtract(long... operands) {
        return LongStream.of(operands).reduce((l, r) -> l - r).getAsLong();
    }

    @Override
    public long multiply(long... operands) {
        return LongStream.of(operands).reduce((l, r) -> l * r).getAsLong();
    }

    @Override
    public long divide(long... operands)throws DivisionByZeroException {
        long ret = operands[0];
        for (int aa = 1; aa < operands.length; aa++) {
            if(operands[aa] == 0){
                throw new DivisionByZeroException("Division By Zero is not possible");
            }
            ret /= operands[aa];
        }
        return ret;
    }

    @Override
    public long pow(long... operands)throws NegativePowerException {
        long ret = operands[0];
        for (int aa = 1; aa < operands.length; aa++) {
            long base = ret;
            long exponent = operands[aa];
            if (exponent < 0) {
                throw new NegativePowerException("Positive integer power only is possible");
            }
            long result = 1;
            for (long bb = 0; bb < exponent; bb++) {
                result *= base;
            }
            ret = result;
        }
        return ret;
    }

}

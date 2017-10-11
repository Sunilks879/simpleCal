package com.cts.commands;

import com.cts.exception.DivisionByZeroException;

public interface Divider {

  long divide(long... operands)throws DivisionByZeroException;

}

package com.cts.commands;

import com.cts.exception.NegativePowerException;

public interface Power {

  long pow(long... operands)throws NegativePowerException;

}

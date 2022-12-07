package com.cydeo.lab08rest.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaymentMethod {
     CREDIT_CARD,  TRANSFER, BUY_NOW_PAY_LATER
}

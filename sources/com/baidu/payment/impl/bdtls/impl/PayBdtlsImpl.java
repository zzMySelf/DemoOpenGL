package com.baidu.payment.impl.bdtls.impl;

import com.baidu.payment.impl.bdtls.ability.PolyBdtlsAbility;
import com.baidu.payment.ioc.IPayBdtlsImplIOC;
import com.baidu.poly.runtime.i.BdtlsAbility;

public class PayBdtlsImpl implements IPayBdtlsImplIOC {
    public BdtlsAbility getBdtlsAbility() {
        return new PolyBdtlsAbility();
    }
}

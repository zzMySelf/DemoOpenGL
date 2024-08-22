package com.baidu.pass.biometrics.face.liveness;

import com.baidu.pass.biometrics.base.PassBiometricOperation;

public class PassFaceOperation implements PassBiometricOperation {
    public OperationType operationType = OperationType.RECOGNIZE;

    public enum OperationType {
        RECOGNIZE("RECOGNIZE");
        
        public String operateName;

        private OperationType(String str) {
            this.operateName = str;
        }
    }
}

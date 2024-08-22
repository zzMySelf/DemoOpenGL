package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

@SinceKotlin(version = "1.4")
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    public final int arity;
    public final int flags;
    public final boolean isTopLevel;
    public final String name;
    public final Class owner;
    public final Object receiver;
    public final String signature;

    public AdaptedFunctionReference(int i2, Class cls, String str, String str2, int i3) {
        this(i2, CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.isTopLevel != adaptedFunctionReference.isTopLevel || this.arity != adaptedFunctionReference.arity || this.flags != adaptedFunctionReference.flags || !Intrinsics.areEqual(this.receiver, adaptedFunctionReference.receiver) || !Intrinsics.areEqual((Object) this.owner, (Object) adaptedFunctionReference.owner) || !this.name.equals(adaptedFunctionReference.name) || !this.signature.equals(adaptedFunctionReference.signature)) {
            return false;
        }
        return true;
    }

    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? Reflection.getOrCreateKotlinPackage(cls) : Reflection.getOrCreateKotlinClass(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int i2 = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        if (cls != null) {
            i2 = cls.hashCode();
        }
        return ((((((((((hashCode + i2) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return Reflection.renderLambdaToString((FunctionBase) this);
    }

    public AdaptedFunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i3 & 1) == 1;
        this.arity = i2;
        this.flags = i3 >> 1;
    }
}

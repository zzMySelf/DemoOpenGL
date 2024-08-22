package fe.mmm.qw.qw;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("SapiStokenManager")
public final class fe {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Semaphore f8252ad = new Semaphore(1);
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public CountDownLatch f8253de;
    public final boolean qw;

    public static final class qw extends GetTplStokenCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe f8254ad;

        public qw(fe feVar) {
            this.f8254ad = feVar;
        }

        public void onFinish() {
        }

        public void onStart() {
        }

        public void onFailure(@Nullable GetTplStokenResult getTplStokenResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("stoken 获取回调 失败：");
            sb.append(getTplStokenResult != null ? Integer.valueOf(getTplStokenResult.getResultCode()) : null);
            sb.append(": ");
            sb.append(getTplStokenResult != null ? getTplStokenResult.getResultMsg() : null);
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
            CountDownLatch qw = this.f8254ad.f8253de;
            if (qw != null) {
                qw.countDown();
            }
        }

        public void onSuccess(@Nullable GetTplStokenResult getTplStokenResult) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("stoken 获取回调 成功：");
            sb.append(getTplStokenResult != null ? getTplStokenResult.tplStokenMap : null);
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
            if (!(getTplStokenResult == null || (str = getTplStokenResult.tplStokenMap.get("aiscan")) == null)) {
                de.f8249fe.when(str);
            }
            CountDownLatch qw = this.f8254ad.f8253de;
            if (qw != null) {
                qw.countDown();
            }
        }
    }

    public fe(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "bduss");
        this.qw = z;
        this.f8253de = this.qw ? new CountDownLatch(1) : null;
    }

    public final void ad() {
        Object obj;
        Object obj2;
        String str;
        if (this.qw) {
            try {
                this.f8252ad.acquire();
                ExpectKt.success(Unit.INSTANCE);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                ExpectKt.failure(th2);
            }
        }
        try {
            if (qw.qw.th().length() > 0) {
                LoggerKt.d$default("account中已存在SToken：" + qw.qw.th(), (Object) null, 1, (Object) null);
                if (this.qw) {
                    this.f8252ad.release();
                    return;
                }
                return;
            }
            LoggerKt.d$default("SToken为空", (Object) null, 1, (Object) null);
            SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
            Map<String, String> tplStoken = accountService != null ? accountService.getTplStoken(new qw(this), qw.qw.fe(), CollectionsKt__CollectionsJVMKt.listOf("aiscan")) : null;
            if (tplStoken == null || (str = tplStoken.get("aiscan")) == null) {
                obj = ExpectKt.success(null);
                if (obj instanceof Either.Left) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("获取SToken异常，");
                    ((Throwable) ((Either.Left) obj).getValue()).printStackTrace();
                    sb.append(Unit.INSTANCE);
                    LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
                    if (this.qw) {
                        this.f8252ad.release();
                    }
                } else if (obj instanceof Either.Right) {
                    LoggerKt.d$default("等待sdk获取stoken", (Object) null, 1, (Object) null);
                    if (this.qw) {
                        try {
                            CountDownLatch countDownLatch = this.f8253de;
                            if (countDownLatch != null) {
                                countDownLatch.await(30000, TimeUnit.MILLISECONDS);
                            }
                            obj2 = ExpectKt.success((String) LoggerKt.d$default("超时，恢复", (Object) null, 1, (Object) null));
                        } catch (Throwable th3) {
                            LoggerKt.e$default(th3, (Object) null, 1, (Object) null);
                            obj2 = ExpectKt.failure(th3);
                        }
                        if (obj2 instanceof Either.Left) {
                            new Either.Left((String) LoggerKt.d$default("wait err " + ((Throwable) ((Either.Left) obj2).getValue()).getMessage(), (Object) null, 1, (Object) null));
                        } else if (!(obj2 instanceof Either.Right)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    if (this.qw) {
                        this.f8252ad.release();
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                LoggerKt.d$default("同步获取到的SToken为" + str, (Object) null, 1, (Object) null);
                de.f8249fe.when(str);
                if (this.qw) {
                    this.f8252ad.release();
                }
            }
        } catch (Throwable th4) {
            if (this.qw) {
                this.f8252ad.release();
            }
            throw th4;
        }
    }
}

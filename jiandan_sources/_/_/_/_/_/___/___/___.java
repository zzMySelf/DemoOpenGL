package _._._._._.___.___;

import com.baidu.netdisk.trade.privilege.io.model.ConsumeFreeCountResponse;
import com.baidu.netdisk.trade.privilege.io.model.PrivilegeListResponse;
import com.baidu.netdisk.trade.privilege.io.model.ProductListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ___ {

    public static final class qw {
        public static /* synthetic */ Call ad(___ ___, String str, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i2 = 1;
                }
                return ___.qw(str, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPrivilege");
        }

        public static /* synthetic */ Call qw(___ ___, String str, int i2, int i3, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    i2 = 1;
                }
                if ((i4 & 4) != 0) {
                    i3 = 1;
                }
                return ___.ad(str, i2, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryUserMember");
        }
    }

    @FormUrlEncoded
    @NotNull
    @POST("user?method=query")
    Call<ProductListResponse> ad(@Field("business_channel") @Nullable String str, @Field("need_privilege") int i2, @Field("need_trial_info") int i3);

    @FormUrlEncoded
    @NotNull
    @POST("user?method=privilegeuse")
    Call<ConsumeFreeCountResponse> de(@Field("business_channel") @Nullable String str, @Field("privilege_id") @Nullable String str2, @Field("fs_id") @Nullable String str3, @Field("op_id") @Nullable String str4);

    @NotNull
    @GET("user?method=privilegequery ")
    Call<PrivilegeListResponse> qw(@Nullable @Query("business_channel") String str, @Query("need_trial_info") int i2);
}

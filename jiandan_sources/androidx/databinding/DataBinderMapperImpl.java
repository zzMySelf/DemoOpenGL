package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
    public DataBinderMapperImpl() {
        addMapper((DataBinderMapper) new com.tera.scan.app.DataBinderMapperImpl());
    }
}

package androidx.databinding;

import android.view.View;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergedDataBinderMapper extends DataBinderMapper {
    public static final String TAG = "MergedDataBinderMapper";
    public Set<Class<? extends DataBinderMapper>> mExistingMappers = new HashSet();
    public List<String> mFeatureBindingMappers = new CopyOnWriteArrayList();
    public List<DataBinderMapper> mMappers = new CopyOnWriteArrayList();

    private boolean loadFeatures() {
        boolean z = false;
        for (String next : this.mFeatureBindingMappers) {
            try {
                Class<?> cls = Class.forName(next);
                if (DataBinderMapper.class.isAssignableFrom(cls)) {
                    addMapper((DataBinderMapper) cls.newInstance());
                    this.mFeatureBindingMappers.remove(next);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException unused2) {
                "unable to add feature mapper for " + next;
            } catch (InstantiationException unused3) {
                "unable to add feature mapper for " + next;
            }
        }
        return z;
    }

    public void addMapper(DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add(dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            for (DataBinderMapper addMapper : dataBinderMapper.collectDependencies()) {
                addMapper(addMapper);
            }
        }
    }

    public String convertBrIdToString(int i2) {
        for (DataBinderMapper convertBrIdToString : this.mMappers) {
            String convertBrIdToString2 = convertBrIdToString.convertBrIdToString(i2);
            if (convertBrIdToString2 != null) {
                return convertBrIdToString2;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(i2);
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        for (DataBinderMapper dataBinder : this.mMappers) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(dataBindingComponent, view, i2);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, view, i2);
        }
        return null;
    }

    public int getLayoutId(String str) {
        for (DataBinderMapper layoutId : this.mMappers) {
            int layoutId2 = layoutId.getLayoutId(str);
            if (layoutId2 != 0) {
                return layoutId2;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(str);
        }
        return 0;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        for (DataBinderMapper dataBinder : this.mMappers) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(dataBindingComponent, viewArr, i2);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, viewArr, i2);
        }
        return null;
    }

    public void addMapper(String str) {
        List<String> list = this.mFeatureBindingMappers;
        list.add(str + ".DataBinderMapperImpl");
    }
}

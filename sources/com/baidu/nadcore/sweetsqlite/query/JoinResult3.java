package com.baidu.nadcore.sweetsqlite.query;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.ReflectionUtils;
import com.baidu.nadcore.sweetsqlite.SQLiteUtils;
import com.baidu.nadcore.sweetsqlite.Table;

public class JoinResult3<T1 extends Table, T2 extends Table, T3 extends Table> {
    public T1 model1;
    public T2 model2;
    public T3 model3;

    private JoinResult3() {
    }

    public static <T1 extends Table, T2 extends Table, T3 extends Table> JoinResult3<T1, T2, T3> create(Cursor cursor, Class<T1> clazz1, Class<T2> clazz2, Class<T3> clazz3) {
        JoinResult3<T1, T2, T3> result = new JoinResult3<>();
        result.model1 = (Table) ReflectionUtils.instance(clazz1);
        result.model2 = (Table) ReflectionUtils.instance(clazz2);
        T3 t3 = (Table) ReflectionUtils.instance(clazz3);
        result.model3 = t3;
        SQLiteUtils.Model.dumpFromCursor(cursor, result.model1, result.model2, t3);
        return result;
    }
}

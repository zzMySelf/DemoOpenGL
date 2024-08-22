package com.baidu.talos.core.render.transition;

import com.baidu.talos.core.render.transition.FunctionParser;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SingleFunctionParser<V> extends FunctionParser<String, List<V>> {

    public interface FlatMapper<V> {
        V map(String str);
    }

    public interface NonUniformMapper<V> {
        List<V> map(List<String> list);
    }

    public SingleFunctionParser(String source, final FlatMapper<V> mapper) {
        super(source, new FunctionParser.Mapper<String, List<V>>() {
            public Map<String, List<V>> map(String functionName, List<String> raw) {
                Map<String, List<V>> map = new HashMap<>();
                List<V> list = new LinkedList<>();
                for (String item : raw) {
                    list.add(FlatMapper.this.map(item));
                }
                map.put(functionName, list);
                return map;
            }
        });
    }

    public SingleFunctionParser(String source, final NonUniformMapper<V> mapper) {
        super(source, new FunctionParser.Mapper<String, List<V>>() {
            public Map<String, List<V>> map(String functionName, List<String> raw) {
                Map<String, List<V>> map = new HashMap<>();
                map.put(functionName, NonUniformMapper.this.map(raw));
                return map;
            }
        });
    }

    public List<V> parse(String functionName) {
        Map<String, List<V>> map = parse();
        if (map.containsKey(functionName)) {
            return map.get(functionName);
        }
        return null;
    }
}

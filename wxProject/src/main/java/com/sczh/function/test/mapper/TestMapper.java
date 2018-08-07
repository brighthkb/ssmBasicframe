package com.sczh.function.test.mapper;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.sczh.function.test.model.Subject;


@Repository
public interface TestMapper {
	List<Subject> getSubjectList(Map<String, Object> mapQuery);
	List<Map<String,Object>> getValueBuKey(String key);
	void add(Map<String, Object> map);
}
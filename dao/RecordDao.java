package dao;

import java.util.List;
import java.util.Map;

import model.Record;

public interface RecordDao {
	void add(Record r);
	
	List<Record> selectRecord(String member_id);
	
	Map<String, Integer> getBorrowCounts();
	
	void update(String member_id);

}

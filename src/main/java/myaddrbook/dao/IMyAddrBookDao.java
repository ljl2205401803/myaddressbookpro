package myaddrbook.dao;

import myaddrbook.pojo.MyAddrBook;

import java.util.List;

public interface IMyAddrBookDao {
	public void save(MyAddrBook myaddrBook) throws Exception;
	public MyAddrBook getMyaddrBookById(int id) throws Exception;
	public void update(MyAddrBook myaddrBook) throws Exception;
	public void deleteById(int id) throws Exception;
	public void deleteByIdes(int[] ides) throws Exception;
	public List<MyAddrBook> getAllMyAddrBook() throws Exception;
}

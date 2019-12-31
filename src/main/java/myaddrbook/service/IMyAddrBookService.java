package myaddrbook.service;

import myaddrbook.pojo.MyAddrBook;

import java.util.List;

public interface IMyAddrBookService {
	public List<MyAddrBook> findAll();
	public Boolean deleteById(int id);
	public Boolean deleteByIdes(int[] ides);
	public Boolean saveMyAddrBook(MyAddrBook myAddrBook);
	public Boolean updateMyAddrBook(MyAddrBook myAddrBook);
	public MyAddrBook findMyAddrBookById(int id);
}

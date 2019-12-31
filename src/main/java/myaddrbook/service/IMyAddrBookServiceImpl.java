package myaddrbook.service;

import myaddrbook.dao.IMyAddrBookDao;
import myaddrbook.dao.IMyAddrBookDaoImpl;
import myaddrbook.pojo.MyAddrBook;

import java.util.List;

public class IMyAddrBookServiceImpl implements IMyAddrBookService {
	//业务逻辑层依赖于数据访问层
	private IMyAddrBookDao myAddrBookDao = new IMyAddrBookDaoImpl();

	@Override
	public List<MyAddrBook> findAll() {
		List<MyAddrBook> list = null;
		try {
			list = myAddrBookDao.getAllMyAddrBook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Boolean deleteById(int id) {
		Boolean flag = true;
		try {
			myAddrBookDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public Boolean deleteByIdes(int[] ides) {
		Boolean flag = true;
		try {
			myAddrBookDao.deleteByIdes(ides);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Boolean saveMyAddrBook(MyAddrBook myAddrBook) {
		Boolean flag = true;
		try {
			myAddrBookDao.save(myAddrBook);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Boolean updateMyAddrBook(MyAddrBook myAddrBook) {
		Boolean flag = true;
		try {
			myAddrBookDao.update(myAddrBook);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public MyAddrBook findMyAddrBookById(int id) {
		MyAddrBook myAddrBook = null;
		try {
			myAddrBook = myAddrBookDao.getMyaddrBookById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myAddrBook;
	}

}

package myaddrbook.dao;

import myaddrbook.pojo.MyAddrBook;

import java.util.ArrayList;
import java.util.List;

public class IMyAddrBookDaoImpl extends BaseDao implements IMyAddrBookDao {

	@Override
	public void save(MyAddrBook myaddrBook) throws Exception {
		String sql = "insert into myAddrBook(firstName,lastName,jobTitle,department,mobile,offPh,email) values(?,?,?,?,?,?,?)";
		try {
			preStmt = super.createPreStmt(sql);
			
			preStmt.setString(1, myaddrBook.getFirstName());
			preStmt.setString(2, myaddrBook.getLastName());
			preStmt.setString(3, myaddrBook.getJobTitle());
			preStmt.setString(4, myaddrBook.getDepartment());
			preStmt.setString(5, myaddrBook.getMobile());
			preStmt.setString(6, myaddrBook.getOffPh());
			preStmt.setString(7, myaddrBook.getEmail());

			preStmt.executeUpdate();
		} catch(Exception ex) {
			throw ex;
		} finally {
			close();
		}
	}

	@Override
	public MyAddrBook getMyaddrBookById(int id) throws Exception {
		MyAddrBook myAddrBook = null;
		String sql = "select id,firstName,lastName,jobTitle,department,mobile,offPh,email from contact where id=?";
		try {
			preStmt = super.createPreStmt(sql);
			
			preStmt.setInt(1, id);
			rs = preStmt.executeQuery();
			if(rs.next()) {
				myAddrBook = new MyAddrBook();
				myAddrBook.setId(rs.getInt(1));
				myAddrBook.setFirstName(rs.getString(2));
				myAddrBook.setLastName(rs.getString(3));
				myAddrBook.setJobTitle(rs.getString(4));
				myAddrBook.setDepartment(rs.getString(5));
				myAddrBook.setMobile(rs.getString(6));
				myAddrBook.setOffPh(rs.getString(7));
				myAddrBook.setEmail(rs.getString(8));
			}
		} catch(Exception ex) {
			throw ex;
		} finally {
			close();
		}
		return myAddrBook;
	}

	@Override
	public void update(MyAddrBook myaddrBook) throws Exception {
		String sql = "update contact set firstName=?,lastName=?,jobTitle=?,department=?,mobile=?,offPh=?,email=? where id=?";
		try {
			preStmt = super.createPreStmt(sql);
			
			preStmt.setString(1, myaddrBook.getFirstName());
			preStmt.setString(2, myaddrBook.getLastName());
			preStmt.setString(3, myaddrBook.getJobTitle());
			preStmt.setString(4, myaddrBook.getDepartment());
			preStmt.setString(5, myaddrBook.getMobile());
			preStmt.setString(6, myaddrBook.getOffPh());
			preStmt.setString(7, myaddrBook.getEmail());
			preStmt.setInt(8, myaddrBook.getId());

			preStmt.executeUpdate();
		} catch(Exception ex) {
			throw ex;
		} finally {
			close();
		}
	}

	@Override
	public void deleteById(int id) throws Exception {
		String sql = "delete from contact where id = ?";
		try {
			preStmt = super.createPreStmt(sql);
			preStmt.setInt(1, id);
			preStmt.executeUpdate();
		} catch(Exception ex) {
			throw ex;
		} finally {
			close();
		}
	}

	@Override
	public void deleteByIdes(int[] ides) throws Exception {
		StringBuffer sql = new StringBuffer("delete from contact where ");
		if(ides.length>0) {
			for(int i:ides) {
				sql.append("id=")
				   .append(i)
				   .append(" or ");
			}
			
			String str = sql.toString().substring(0,sql.toString().lastIndexOf("or"));
			
			try {
				preStmt = super.createPreStmt(str);
				preStmt.executeUpdate();
			} catch(Exception ex) {
				throw ex;
			} finally {
				close();
			}
		}
	}

	@Override
	public List<MyAddrBook> getAllMyAddrBook() throws Exception {
		List<MyAddrBook> list = new ArrayList<MyAddrBook>();
		String sql = "select id,firstName,lastName,jobTitle,department,mobile,offPh,email from contact";
		try {
			preStmt = super.createPreStmt(sql);
			rs = preStmt.executeQuery();
			while(rs.next()) {
				MyAddrBook myAddrBook = new MyAddrBook();
				myAddrBook.setId(rs.getInt(1));
				myAddrBook.setFirstName(rs.getString(2));
				myAddrBook.setLastName(rs.getString(3));
				myAddrBook.setJobTitle(rs.getString(4));
				myAddrBook.setDepartment(rs.getString(5));
				myAddrBook.setMobile(rs.getString(6));
				myAddrBook.setOffPh(rs.getString(7));
				myAddrBook.setEmail(rs.getString(8));
				list.add(myAddrBook);
			}
		} catch(Exception ex) {
			throw ex;
		} finally {
			close();
		}
		return list;
	}

}

package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.util.JDBCUtil;
import com.example.bean.BoardVO;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class BoardDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;

    private final String BOARD_INSERT = "insert into CONTACT (name, phoneNum, email, birthDate, photo) values (?,?,?,?,?)";
    private final String BOARD_UPDATE = "update CONTACT set name=?, phoneNum=?, email=?, birthDate=?, photo=? where seq=?";
    private final String BOARD_DELETE = "delete from CONTACT where seq=?";
    private final String BOARD_GET = "select * from CONTACT where seq=?";
    private final String BOARD_LIST = "select * from CONTACT order by seq desc";

    public BoardDAO() {
        this.conn = null;
        this.stmt = null;
        this.rs = null;
    }

    public int insertContact(final BoardVO vo) {
        try {
            this.conn = JDBCUtil.getConnection();
            (this.stmt = this.conn.prepareStatement("insert into CONTACT (name, phoneNum, email, birthDate, photo) values (?,?,?,?,?)")).setString(1, vo.getName());
            this.stmt.setString(2, vo.getPhoneNum());
            this.stmt.setString(3, vo.getEmail());
            this.stmt.setString(4, vo.getBirthDate());
            this.stmt.setString(5, vo.getPhoto());
            this.stmt.executeUpdate();
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateContact(final BoardVO vo) {
        try {
            this.conn = JDBCUtil.getConnection();
            (this.stmt = this.conn.prepareStatement("update CONTACT set name=?, phoneNum=?, email=?, birthDate=?, photo=? where seq=?")).setString(1, vo.getName());
            this.stmt.setString(2, vo.getPhoneNum());
            this.stmt.setString(3, vo.getEmail());
            this.stmt.setString(4, vo.getBirthDate());
            this.stmt.setString(5, vo.getPhoto());
            this.stmt.setInt(6, vo.getSeq());
            this.stmt.executeUpdate();
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void deleteContact(final BoardVO vo) {
        try {
            this.conn = JDBCUtil.getConnection();
            (this.stmt = this.conn.prepareStatement("delete from CONTACT where seq=?")).setInt(1, vo.getSeq());
            this.stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BoardVO getContact(final int seq) {
        final BoardVO detail = new BoardVO();

        try {
            this.conn = JDBCUtil.getConnection();
            (this.stmt = this.conn.prepareStatement("select * from CONTACT where seq=?")).setInt(1, seq);
            this.rs = this.stmt.executeQuery();

            if (this.rs.next()) {
                detail.setSeq(this.rs.getInt("seq"));
                detail.setName(this.rs.getString("name"));
                detail.setPhoneNum(this.rs.getString("phoneNum"));
                detail.setEmail(this.rs.getString("email"));
                detail.setBirthDate(this.rs.getString("birthDate"));
                detail.setPhoto(this.rs.getString("photo"));
            }

            this.rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return detail;
    }

    public List<BoardVO> getContactList() {
        final List<BoardVO> list = new ArrayList<BoardVO>();

        try {
            this.conn = JDBCUtil.getConnection();
            this.stmt = this.conn.prepareStatement("select * from CONTACT order by seq desc");
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                final BoardVO detail = new BoardVO();
                detail.setSeq(this.rs.getInt("seq"));
                detail.setName(this.rs.getString("name"));
                detail.setPhoneNum(this.rs.getString("phoneNum"));
                detail.setEmail(this.rs.getString("email"));
                detail.setBirthDate(this.rs.getString("birthDate"));
                detail.setPhoto(this.rs.getString("photo"));
                list.add(detail);
            }

            this.rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getPhotoFilename(final int seq) {
        String filename = null;

        try {
            this.conn = JDBCUtil.getConnection();
            (this.stmt = this.conn.prepareStatement("select * from CONTACT  where seq=?")).setInt(1, seq);
            this.rs = this.stmt.executeQuery();

            if (this.rs.next()) {
                filename = this.rs.getString("photo");
            }

            this.rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return filename;
    }
}

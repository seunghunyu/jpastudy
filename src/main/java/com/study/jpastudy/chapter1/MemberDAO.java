package com.study.jpastudy.chapter1;

import com.study.jpastudy.chapter1.data1.Member;
import com.study.jpastudy.chapter1.data1.Team;

import java.sql.*;

public class MemberDAO {
    String url = "jdbc:h2:~/test"; // 파일 기반 H2 DB (~/test는 홈 디렉토리의 test 파일)
    String user = "sa";            // 기본 사용자명
    String password = "";

    public Member find(String memberId){
        String qry = " SELECT MEMBER_ID, NAME, TEL FROM MEMBER M WHERE MEMBER_ID = ? ";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member = new Member();
        try {
            // H2 JDBC 드라이버 로드
            Class.forName("org.h2.Driver");
            // 데이터베이스 연결
            con = DriverManager.getConnection(url, user, password);
            // 쿼리 실행
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, "1");
            rs = pstmt.executeQuery();

            if(rs.next()){
                member.setMemberId(rs.getString("MEMBER_ID"));
                member.setName(rs.getString("NAME"));
                member.setTel(rs.getString("TEL"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstmt != null) try{pstmt.close();}catch (Exception e){e.printStackTrace();}
            if(rs != null) try{rs.close();}catch (Exception e){e.printStackTrace();}
        }

        return member;
    }

    public void save(Member member){
        String qry = " INSERT INTO MEMBER(MEMBER_ID, NAME, TEL) VALUES(?, ?, ?) ";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // H2 JDBC 드라이버 로드
            Class.forName("org.h2.Driver");
            // 데이터베이스 연결
            con = DriverManager.getConnection(url, user, password);
            // 쿼리 실행
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, member.getMemberId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getTel());
            pstmt.executeUpdate();
            con.commit();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstmt != null) try{pstmt.close();}catch (Exception e){e.printStackTrace();}
            if(rs != null) try{rs.close();}catch (Exception e){e.printStackTrace();}
        }
    }

    public Member findWithTeam(String memberId){
        String qry = " SELECT M.MEMBER_ID, M.NAME, M.TEL, T.TEAM_ID, T.TEAM_NAME FROM MEMBER M INNER JOIN TEAM T ON M.TEAM_ID = T.TEAM_ID WHERE M.MEMBER_ID = ? ";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member = new Member();
        Team team = new Team();
        try {
            // H2 JDBC 드라이버 로드
            Class.forName("org.h2.Driver");
            // 데이터베이스 연결
            con = DriverManager.getConnection(url, user, password);
            // 쿼리 실행
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, "1");
            rs = pstmt.executeQuery();

            if(rs.next()){
                member.setMemberId(rs.getString("MEMBER_ID"));
                member.setName(rs.getString("NAME"));
                member.setTel(rs.getString("TEL"));
                team.setTeamId(rs.getString("TEAM_ID"));
                team.setTeamName(rs.getString("TEAM_NAME"));
                member.setTeam(team);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstmt != null) try{pstmt.close();}catch (Exception e){e.printStackTrace();}
            if(rs != null) try{rs.close();}catch (Exception e){e.printStackTrace();}
        }

        return member;
    }
}

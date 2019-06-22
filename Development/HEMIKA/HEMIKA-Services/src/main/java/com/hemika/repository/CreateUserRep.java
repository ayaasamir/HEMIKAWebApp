package com.hemika.repository;
//import com.hemika.model.UserData;
//import com.hemika.model.UserData;
import com.hemika.model.UserData;
import com.hemika.model.UserDtoData;
//import com.hemika.model.rm.UserTypeRM;
//import com.hemika.model.rm.UserTypeRM;
import com.hemika.model.rm.UserTypeRM;
import com.hemika.service.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CreateUserRep {
    private UserDtoData userData;
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private SecurityManager securityManager;
    ////////////////////////////////////////////////////////
    //private HashPasswordSer hashPasswordSer;
//    public String hashPassword(LoginUserDTO data) throws Exception {
//        Response response = this.securitySer.Login(data);
//        return response;
//    }
//public String hashPassword(UserDtoData userData) throws Exception {
//    //String hashedPassword = securityManager.dm5Hash(userData.getPassword());
//    //String hashedConfirmPassword = securityManager.dm5Hash(data.getConfirmPassword());
//    //return hashedPassword;
//    String hashedPass = hashPasswordSer.hashPassword(userData);
//    System.out.println(hashedPass);
//    return hashedPass;
//}
//    public String hashConfirmPassword(UserDtoData userData) throws Exception {
//        //String hashedPassword = securityManager.dm5Hash(data.getPassword());
//        //String hashedConfirmPassword = securityManager.dm5Hash(userData.getConfirmPassword());
//        String hashedConfirmPass = hashPasswordSer.hashConfirmPassword(userData);
//        System.out.println(hashedConfirmPass);
//        return hashedConfirmPass;
//    }
/////////////////////////////////////////////////////////////////
//    public void insertType(UserData userData) throws Exception{
//        String sql = "select * from role_t where label_en = ?;";
//        RowMapper<UserData> rowMapper = new UserTypeRM();
//        UserData user = jdbc.queryForObject(sql, rowMapper, label_en);
//    }

/////////////////////////////////////////////////////////////////////////////////
//    public void insertNewUser(UserDtoData data) throws Exception {
//        String hashedPass = securityManager.dm5Hash(data.getPassword());
//        //String hashedConfirmPass = securityManager.dm5Hash(data.getConfirmPassword());
//        System.out.println(hashedPass);
//        System.out.println(data.getConfirmPassword());
//        String sql="INSERT INTO users (first_name,last_name,user_name," +
//                "user_type,pass,confirm_pass)VALUES (?,?,?,?,?,?)";
//        this.jdbc.update(sql,data.getFirstName(),data.getLastName(),data.getUserName(),
//                data.getType(),hashedPass,data.getConfirmPassword());
//
//
//    }

////////////////////////////////////////////////////////////////////////////
//    String sql1 = "SELECT `id` FROM mydb.role_t WHERE label_en = ?;";
//    RowMapper<UserData> rowMapper = new UserTypeRM();
//    UserData userData1= jdbc.queryForObject(sql1 ,rowMapper,data.getType());
//
//
//    //        System.out.println(sql1);
//    String sql2="INSERT INTO user_t_has_role_t (user_t_national_id,role_t_id)" +
//            "VALUES (?,?)";
//        this.jdbc.update(sql2,data.getNationalID(),);
    ///////////////////////////////////////////////////////////
    //////////////////////////////////////////////
    public void insertNewUser(UserDtoData data) throws Exception {
        String hashedPass = securityManager.dm5Hash(data.getConfirmPassword());
        //String hashedConfirmPass = securityManager.dm5Hash(data.getConfirmPassword());

        System.out.println(data.getPassword());
        System.out.println(hashedPass);
        String sql="INSERT INTO mydb.user_t (national_id,first_name,last_name,user_address," +
                "user_mobile_number,user_name,user_birth_date,user_password,"+
                "hashed_password,email)VALUES (?,?,?,?,?,?,?,?,?,?)";
        this.jdbc.update(sql,data.getNationalID(),data.getFirstName(),data.getLastName(),
                data.getAddress(),data.getMobileNumber(),data.getUserName(),
                data.getBirthDate(),data.getPassword(),hashedPass,
                data.getEmail());
        String sql1 = "SELECT * FROM mydb.role_t WHERE id = ?;";
        RowMapper<UserData>userDataRowMapper=new UserTypeRM();
        UserData userData =this.jdbc.queryForObject(sql1,userDataRowMapper,data.getType());
        String sql2="INSERT INTO mydb.user_t_has_role_t (user_t_national_id,role_t_id)" +
                "VALUES (?,?)";
        this.jdbc.update(sql2,data.getNationalID(),userData.getId());
    }



}



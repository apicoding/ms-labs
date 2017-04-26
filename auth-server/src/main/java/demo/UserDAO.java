package demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public UserInfo getUserInfo(String username) {
        String sqlUser = "select users.username as username,users.password as password from users where users.username=? ";
        UserInfo userInfo = (UserInfo) jdbcTemplate.queryForObject(sqlUser, new Object[] { username }, new RowMapper<UserInfo>() {
            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserInfo user = new UserInfo();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return userInfo;
    }

    public List<String> findAuthorities(String username) {
        String sql = "select authorities.authority as authority from authorities where authorities.username=? ";
        List<String> autho = jdbcTemplate.queryForList(sql, String.class, new Object[] { username });
        return autho;
    }
}

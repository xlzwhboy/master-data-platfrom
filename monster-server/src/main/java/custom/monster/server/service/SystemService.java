package custom.monster.server.service;


import custom.monster.entity.system.PrivilegeType;
import custom.monster.entity.system.SystemPrivilege;
import custom.monster.entity.system.Team;
import custom.monster.entity.system.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface SystemService {
    Page<User> listUsers(int page, int size, String sort, Sort.Direction direction);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    User findUserById(long id);

    User findUserByName(String name);

    Page<Team> listTeams(int page, int size, String sort, Sort.Direction direction);

    List<String> listTeamNames();


    void addTeam(Team team);

    void updateTeam(Team team);

    void deleteTeam(long id);

    Team findTeamById(long id);

    Team findTeamByName(String name);

    SystemPrivilege findSystemPrivilege(String team, PrivilegeType privilegeType);

    void addSystemPrivilege(SystemPrivilege systemPrivilege);

    void delSystemPrivilege(long id);

    Page<SystemPrivilege> listSystemPrivileges(int page, int size, String sort, Sort.Direction direction);
}

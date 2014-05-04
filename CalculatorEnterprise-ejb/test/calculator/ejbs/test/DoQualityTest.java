/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator.ejbs.test;

import calculator.ejbs.controller.RoleFacade;
import calculator.ejbs.controller.UserFacade;
import calculator.ejbs.controller.UserRoleFacade;
import calculator.ejbs.entity.Role;
import calculator.ejbs.entity.User;
import calculator.ejbs.entity.UserRole;

/**
 *
 * @author alessandro
 */
public class DoQualityTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Init test of quality");
        User user1 = new User();
        user1.setName("Alessandro");
        
        UserFacade userF = new UserFacade();
        userF.create(user1);
        
        System.out.println("Create a new user");
        System.out.println("userid: " + user1.getId());
        System.out.println("username: " + user1.getName());
        
        Role role1 = new Role();
        role1.setName("Permisão para Calcular");
        
        RoleFacade roleF = new RoleFacade();
        roleF.create(role1);
        
        System.out.println("Create a new role");
        System.out.println("roleid: " + role1.getId());
        System.out.println("rolename: " + role1.getName());
        
        
        UserRole userrole = new UserRole();
        userrole.setUserid(user1.getId());
        userrole.setRoleid(role1.getId());
        
        UserRoleFacade userroleF = new UserRoleFacade();
        userroleF.create(userrole);
        
        System.out.println("Create a new relation");
        System.out.println("id: " + userrole.getId());
        System.out.println("userid: " + userrole.getUserid());
        System.out.println("roleid: " + userrole.getRoleid());
        
    }
    
}

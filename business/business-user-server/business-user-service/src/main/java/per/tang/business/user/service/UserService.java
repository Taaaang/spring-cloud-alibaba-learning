package per.tang.business.user.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.util.Assert;
import pers.tang.business.user.api.IUserService;
import pers.tang.business.user.api.entity.User;

@Service(version = "${provider.user.service.version}")
public class UserService implements IUserService {

    public User getUser(Integer userId) {
        Assert.notNull(userId,"userId is null!");
        Assert.isTrue(userId>0,"userId less than 0");
        User user=new User(userId,"用户"+userId,10);
        System.out.println("用户信息查询完毕==>"+user.toString());
        return user;
    }
}

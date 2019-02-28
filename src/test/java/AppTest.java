import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.npcka.NpckaApplication;
import pers.npcka.dao.GameMapper;
import pers.npcka.dao.GameServerMapper;
import pers.npcka.dao.GiftMapper;
import pers.npcka.dao.UsersMapper;
import pers.npcka.model.Game;
import pers.npcka.model.Gift;
import pers.npcka.model.Guide;
import pers.npcka.model.Users;
import pers.npcka.service.GiftService;
import pers.npcka.service.GuideService;
import pers.npcka.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NpckaApplication.class)
public class AppTest {

    @Autowired(required = false)
    UsersMapper usersMapper;
    @Autowired(required = false)
    GameMapper gameMapper;
    @Autowired(required = false)
    GiftMapper giftMapper;
    @Autowired(required = false)
    GameServerMapper gameServerMapper;

    @Autowired
    GuideService guideService;
    @Autowired
    GiftService giftService;
    @Autowired
    UserService userService;

    @Test
    public void test() {
        List<Guide> page = null;
        try {
            page = guideService.getNewsListByPage(2, 2, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Guide d : page) {
            System.out.println(d.getId());
            System.out.println(d.getCreateTime());
        }
    }

    @Test
    public void test2() {
        List<Game> gameGift = gameMapper.getAllGameGift();
        for (Game g : gameGift) {
            for (Gift g1 : g.getGifts()) {
                System.out.println(g1.toString());
            }
            System.out.println(g.toString());
        }
    }

    @Test
    public void test3() {
        Gift gift = null;
        try {
            gift = giftMapper.getGiftDetailById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(gift.toString());
        System.out.println(gift.getGame().toString());
    }

    @Test
    public void test4() {
        try {
            int newsCount = guideService.getNewsCount("");
            int guideCount = guideService.getGuideCount("");
            System.out.println(newsCount);
            System.out.println(guideCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        List<Gift> gift = null;
        try {
            gift = giftService.getAllGift("", 2, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Gift g : gift) {
            System.out.println(g.getId());
        }
    }

    @Test
    public void test6() {
        Users users = null;
        try {
            users = userService.goToLogin("1@1.com", "111");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(users.getEmail());
    }
}

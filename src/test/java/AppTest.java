import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.npcka.NpckaApplication;
import pers.npcka.dao.GameMapper;
import pers.npcka.dao.GiftMapper;
import pers.npcka.dao.UsersMapper;
import pers.npcka.model.Game;
import pers.npcka.model.Gift;
import pers.npcka.model.Guide;
import pers.npcka.service.GuideService;

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

    @Autowired
    GuideService guideService;

    @Test
    public void test() {
        List<Guide> page = null;
        try {
            page = guideService.getNewsListByPage(1, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Guide d : page)
            System.out.println(d.getId());
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
        Gift gift = giftMapper.getGiftDetailById(1);
        System.out.println(gift.toString());
        System.out.println(gift.getGame().toString());
    }
}

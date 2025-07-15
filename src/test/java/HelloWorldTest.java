import me.geeklol.ControlGame.ControlGame;
import org.bukkit.Location;
import org.bukkit.World;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;

public class HelloWorldTest {
    World world;

    @BeforeEach
    void setUp() {
        ServerMock mock = MockBukkit.mock();
        ControlGame plugin = MockBukkit.load(ControlGame.class);
        this.world = mock.addSimpleWorld("test");
    }

    @AfterEach
    void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void test() {
        world.createExplosion(new Location(world, 0, 0, 0), 0.2f);
    }
}
